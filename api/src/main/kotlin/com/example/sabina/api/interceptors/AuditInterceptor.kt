package com.example.sabina.api.interceptors

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KotlinLogging
import org.springframework.lang.Nullable
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception

class AuditInterceptor: HandlerInterceptor {
    companion object {
        private val log = KotlinLogging.logger {}
    }

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        log.info { "Pre handle: $request" }
        return true
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        @Nullable modelAndView: ModelAndView?
    ) {
        log.info { "Post handle: $request" }
    }

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        @Nullable ex: Exception?
    ) {
        log.info { "After completion handle: $request" }
    }
}