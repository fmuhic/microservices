package com.example.sabina.api.models

import jakarta.persistence.*
import java.time.Instant

@Entity(name = "transaction")
data class Transaction (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    var id: Long? = null,

    @Column(name = "account_id", nullable = false)
    var accountId: Long? = null,

    @Column(name = "datetime", nullable = true)
    var datetime: Long? = Instant.now().toEpochMilli(),

    @Column(name = "amount", nullable = true)
    var amount: Double? = null,

    @Column(name = "type", nullable = false)
    var type: TransactionType = TransactionType.REGULAR,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id")
    var from: User? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
    var to: User? = null
)