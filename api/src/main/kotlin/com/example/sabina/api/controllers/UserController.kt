package com.example.sabina.api.controllers

import com.example.sabina.api.models.User
import com.example.sabina.api.repositories.UserRepository
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    val userRepository: UserRepository,
    metricsRegistry: MeterRegistry
) {
    private val listUsersCounter = metricsRegistry.counter("list_users_total")

    @GetMapping
    fun listUsers(): ResponseEntity<MutableList<User>> = ResponseEntity(userRepository.findAll(), HttpStatus.OK).also {
        listUsersCounter.increment()
    }

    @PostMapping
    fun createUser(@RequestBody newUser: User): ResponseEntity<Any> {
        when (val oldUser = userRepository.findByFirstName(newUser.firstName!!)) {
            null -> userRepository.save(newUser).also { println("creating new user") }
            else -> {
                oldUser.lastName += "!"
                userRepository.save(oldUser).also { println("Updating user") }
            }
        }

        return ResponseEntity(HttpStatus.CREATED)
    }
}