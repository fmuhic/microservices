package com.example.sabina.api.models

import jakarta.persistence.*
import org.hibernate.envers.Audited

@Audited
@Entity(name = "account")
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    var id: Long? = null
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    var customer1: User? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_type_id", nullable = false)
    var accountType: AccountType? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_status_code_id", nullable = false)
    var accountStatusCode: AccountStatusCode? = null
}