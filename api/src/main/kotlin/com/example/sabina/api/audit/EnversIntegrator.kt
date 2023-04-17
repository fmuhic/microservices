package com.example.sabina.api.audit

import org.hibernate.boot.Metadata
import org.hibernate.boot.spi.BootstrapContext
import org.hibernate.engine.spi.SessionFactoryImplementor
import org.hibernate.envers.boot.internal.EnversService
import org.hibernate.event.service.spi.EventListenerRegistry
import org.hibernate.event.spi.EventType
import org.hibernate.event.spi.PostCollectionRecreateEventListener
import org.hibernate.event.spi.PostCollectionUpdateEventListener
import org.hibernate.event.spi.PostInsertEventListener
import org.hibernate.event.spi.PostUpdateEventListener
import org.hibernate.event.spi.PreDeleteEventListener
import org.hibernate.event.spi.PreUpdateEventListener
import org.hibernate.integrator.spi.Integrator
import org.hibernate.service.ServiceRegistry
import org.hibernate.service.spi.SessionFactoryServiceRegistry


class EnversIntegrator: Integrator {
    override fun disintegrate(sfi: SessionFactoryImplementor, sfsr: SessionFactoryServiceRegistry) {
        TODO("Not yet implemented")
    }

    override fun integrate(
        metadata: Metadata,
        bootstrapContext: BootstrapContext,
        sessionFactory: SessionFactoryImplementor
    ) {
        val serviceRegistry: ServiceRegistry = sessionFactory.serviceRegistry
        val enversService: EnversService = serviceRegistry.getService(EnversService::class.java)
        if (enversService.entitiesConfigurations.hasAuditedEntities()) {
            val listenerRegistry: EventListenerRegistry = serviceRegistry.getService(EventListenerRegistry::class.java)
            listenerRegistry.setListeners(
                EventType.PRE_UPDATE,
                *arrayOf<PreUpdateEventListener>(PreUpdateHandler(enversService))
            )
            listenerRegistry.setListeners(
                EventType.POST_UPDATE,
                *arrayOf<PostUpdateEventListener>(PostUpdateHandler(enversService))
            )
            listenerRegistry.setListeners(
                EventType.POST_INSERT,
                *arrayOf<PostInsertEventListener>(PostInsertHandler(enversService))
            )
        }
    }
}