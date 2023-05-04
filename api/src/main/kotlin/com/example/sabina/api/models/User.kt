package com.example.sabina.api.models

import jakarta.persistence.*
import org.hibernate.envers.Audited

@Audited
@Entity(name = "person")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null
}