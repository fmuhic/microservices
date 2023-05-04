package com.example.sabina.api.controllers

import com.example.sabina.api.models.Transaction
import com.example.sabina.api.models.User
import com.example.sabina.api.repositories.TransactionRepository
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController(
    metricsRegistry: MeterRegistry, private val transactionRepository: TransactionRepository
) {
    private val listTransactionsCounter = metricsRegistry.counter("list_transactions_total")

    @GetMapping
    fun listTransactions(): ResponseEntity<MutableList<Transaction>> =
        ResponseEntity(transactionRepository.findAll(), HttpStatus.OK).also {
            listTransactionsCounter.increment()
        }

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transaction): ResponseEntity<Any> {
        transactionRepository.save(transaction).also { println("Creating new transaction") }
        return ResponseEntity(HttpStatus.CREATED)
    }
}