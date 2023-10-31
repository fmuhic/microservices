package com.example.sabina.api.models

import jakarta.persistence.*

@Entity(name = "users")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    var id: Long? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,
)