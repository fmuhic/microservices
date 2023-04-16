package com.example.sabina.api.models

import jakarta.persistence.*
import org.hibernate.envers.Audited

@Audited
@Entity(name = "person")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
)