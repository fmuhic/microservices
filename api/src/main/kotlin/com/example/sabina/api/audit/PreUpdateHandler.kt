package com.example.sabina.api.audit

import com.example.sabina.api.models.User
import org.hibernate.envers.boot.internal.EnversService
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl
import org.hibernate.event.spi.PreUpdateEvent

class PreUpdateHandler(enversService: EnversService): EnversPreUpdateEventListenerImpl(enversService) {
    override fun onPreUpdate(event: PreUpdateEvent): Boolean =
        when (val e = event.entity) {
            is User -> {
                println("user here ______________")
                if(e.firstName == "Fuad") {
                    println("onPreUpdate: executed __________________________________________________________________")
                    false
                }
                else super.onPreUpdate(event).also { println("User going through") }
            }
            else -> super.onPreUpdate(event)
        }
}