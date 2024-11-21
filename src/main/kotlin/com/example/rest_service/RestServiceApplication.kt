package com.example.rest_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestServiceApplication

fun main(args: Array<String>) {
	runApplication<RestServiceApplication>(*args)
}
