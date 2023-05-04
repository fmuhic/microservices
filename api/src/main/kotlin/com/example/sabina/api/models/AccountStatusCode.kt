package com.example.sabina.api.models

import jakarta.persistence.*
import org.hibernate.envers.Audited

@Audited
@Entity(name = "account_status_code")
class AccountStatusCode(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    var id: Long? = null,
    var name: String? = null
)