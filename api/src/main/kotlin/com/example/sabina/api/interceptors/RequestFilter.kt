package com.example.sabina.api.interceptors

import jakarta.servlet.*
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponseWrapper
import mu.KotlinLogging.logger
import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import java.io.*


@Component
class RequestFilter : Filter {
    companion object {
        private val log = logger {}
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        log.info { "Filtering request first" }
        chain.doFilter(CachedBodyHttpServletRequest(request as HttpServletRequest), response)
    }
}

class CachedBodyHttpServletRequest(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private val cachedBody: ByteArray

    init {
        val requestInputStream: InputStream = request.inputStream
        cachedBody = StreamUtils.copyToByteArray(requestInputStream)
    }

    override fun getInputStream(): ServletInputStream = CachedBodyServletInputStream(cachedBody)

    override fun getReader(): BufferedReader = BufferedReader(InputStreamReader(ByteArrayInputStream(cachedBody)))
}

class CachedBodyServletInputStream(cachedBody: ByteArray) : ServletInputStream() {
    private val cachedBodyInputStream: InputStream = ByteArrayInputStream(cachedBody)

    override fun read() = cachedBodyInputStream.read()

    override fun isFinished() = cachedBodyInputStream.available() == 0

    override fun isReady() = true

    override fun setReadListener(listener: ReadListener) {
        throw UnsupportedOperationException("Method not implemented")
    }
}