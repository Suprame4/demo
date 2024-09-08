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
	fun index(@RequestParam("name") name: String) = "Hello, $name!"
}