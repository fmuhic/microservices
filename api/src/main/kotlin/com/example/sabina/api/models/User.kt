package com.example.sabina.api.models

import jakarta.persistence.*


@Entity(name = "person")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    var id: Long? = null,

    var firstName: String? = null,

    var lastName: String? = null,
)