package com.example.sabina.api.repositories

import com.example.sabina.api.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.history.RevisionRepository

interface UserRepository : JpaRepository<User, Long>, RevisionRepository<User, Long, Int> {
    fun findByFirstName(name: String): User?
}