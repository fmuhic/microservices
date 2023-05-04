package com.example.sabina.api.controllers

import com.example.sabina.api.kafka.KafkaTransactionService
import com.example.sabina.api.models.Transaction
import com.example.sabina.api.models.User
import com.example.sabina.api.repositories.TransactionRepository
import io.micrometer.core.instrument.MeterRegistry
import mu.KotlinLogging.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController(
    private val transactionRepository: TransactionRepository,
    private val kafkaTransactionService: KafkaTransactionService,
    metricsRegistry: MeterRegistry
) {
    companion object {
        private val log = logger {}
    }
    private val listTransactionsCounter = metricsRegistry.counter("list_transactions_total")

    @GetMapping
    fun listTransactions() =
        ResponseEntity(transactionRepository.findAll(), HttpStatus.OK).also {
            listTransactionsCounter.increment()
        }

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transaction): ResponseEntity<Any> {
        transactionRepository.save(transaction)
        log.info("Creating new transaction")
        kafkaTransactionService.send(transaction)
        return ResponseEntity(HttpStatus.CREATED)
    }
}