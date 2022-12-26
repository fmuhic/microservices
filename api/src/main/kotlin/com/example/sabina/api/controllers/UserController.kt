package com.example.sabina.api.controllers

import com.example.sabina.api.models.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/")
    fun listUsers(): User {
        val user = User(12345L, "Daniel", "Ricciardo");
        return user
    }

}