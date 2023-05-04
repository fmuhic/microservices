package com.example.sabina.api.models

import jakarta.persistence.*
import org.hibernate.envers.Audited
import java.time.Instant

@Audited
@Entity(name = "transaction")
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    var id: Long? = null

    @Column(name = "account_id", nullable = false)
    var accountId: Long? = null

    @Column(name = "datetime", nullable = true)
    var datetime: Instant? = Instant.now()

    @Column(name = "amount", nullable = true)
    var amount: Double? = 0.0

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_type_id", nullable = false)
    var transactionType: TransactionType? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_id")
    var from: User? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
    var to: User? = null
}