package com.example.sabina.api.repositories

import com.example.sabina.api.models.Transaction
import com.example.sabina.api.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.history.RevisionRepository

interface TransactionRepository : JpaRepository<Transaction, Long>, RevisionRepository<Transaction, Long, Int> {
    fun findByFrom(name: String): User?
}