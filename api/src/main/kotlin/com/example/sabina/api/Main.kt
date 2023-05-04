package com.example.sabina.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}
