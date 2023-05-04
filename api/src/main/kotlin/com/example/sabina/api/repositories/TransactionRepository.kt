package com.example.sabina.api.repositories

import com.example.sabina.api.models.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<Transaction, Long>