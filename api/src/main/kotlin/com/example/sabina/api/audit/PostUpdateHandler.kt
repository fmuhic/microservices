package com.example.sabina.api.audit

import com.example.sabina.api.models.User
import org.hibernate.envers.boot.internal.EnversService
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl
import org.hibernate.envers.event.spi.EnversPreUpdateEventListenerImpl
import org.hibernate.event.spi.PostUpdateEvent
import org.hibernate.event.spi.PreUpdateEvent
class PostUpdateHandler(enversService: EnversService): EnversPostUpdateEventListenerImpl(enversService) {
    override fun onPostUpdate(event: PostUpdateEvent) {
        when (val e = event.entity) {
            is User -> {
                println("user here ______________")
                if (e.firstName == "Fuad") {
                    println("onPostUpdate: executed __________________________________________________________________")
                    return
                } else super.onPostUpdate(event).also { println("User going through") }
            }

            else -> super.onPostUpdate(event)
        }
    }
}