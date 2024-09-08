package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication
// If the class doesn't include any members, you can omit the class body

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

// controller
@RestController
class MessageController {
	@GetMapping("/")
	fun index() = listOf(
		Message("1", "hello!"),
		Message("2", "Bonjour!"),
		Message("3", "Privet!"),
	)
}
/*
A data class is a special type of class that is used to hold data - It provides several useful features for
managing immutable data
 */
data class Message(
	val id: String?,
	val text: String
)