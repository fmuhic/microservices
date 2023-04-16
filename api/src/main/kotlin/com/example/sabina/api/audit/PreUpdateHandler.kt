package com.example.sabina.api.audit

import com.example.sabina.api.models.User
import org.hibernate.envers.boot.internal.EnversService
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl
import org.hibernate.event.spi.PreUpdateEvent
class PreUpdateHandler(enversService: EnversService): EnversPreUpdateEventListenerImpl(enversService) {
    override fun onPreUpdate(event: PreUpdateEvent): Boolean =
        when (val e = event.entity) {
            is User -> {
                e.firstName != "Fuad".also {
                    println("onPreUpdate: executed __________________________________________________________________")
                }
            }
            else -> super.onPreUpdate(event)
        }
}