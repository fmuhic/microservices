package com.example.sabina.api.audit

import com.example.sabina.api.models.User
import org.hibernate.envers.boot.internal.EnversService
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl
import org.hibernate.event.spi.PostInsertEvent
import org.hibernate.event.spi.PreUpdateEvent

class PostInsertHandler(enversService: EnversService): EnversPostInsertEventListenerImpl(enversService) {

    override fun onPostInsert(event: PostInsertEvent) {
        when (val e = event.entity) {
            is User -> {
                e.firstName != "Fuad".also {
                    println("onPostInsert: executed __________________________________________________________________")
                }
            }

            else -> super.onPostInsert(event)
        }
    }
}