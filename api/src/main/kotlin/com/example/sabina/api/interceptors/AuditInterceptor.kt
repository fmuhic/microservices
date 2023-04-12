package com.example.sabina.api.interceptors

import com.example.sabina.api.models.User
import com.google.gson.Gson
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KotlinLogging.logger
import org.springframework.lang.Nullable
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.util.stream.Collectors


class AuditInterceptor: HandlerInterceptor {
    companion object {
        private val log = logger {}
        private val gson = Gson()
    }

    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        request.headerNames.asIterator().forEach {
            log.info { "Pre handle header: $it : ${request.getHeader(it)}" }
        }
        val user = gson.fromJson(request.reader.lines().collect(Collectors.joining()), User::class.java)
        println("Body bytes: $user")
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