package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.io.Serial
import java.util.*

@SpringBootApplication
class DemoApplication
// If the class doesn't include any members, you can omit the class body

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

// controller
@RestController
class MessageController(val service: MessageService) {
	@GetMapping("/")
	fun index(): List<Message> = service.findMessages()

	@PostMapping("/")
	fun post(@RequestBody message: Message){
		service.save(message)
	}
}
/*
A data class is a special type of class that is used to hold data - It provides several useful features for
managing immutable data
 */
data class Message(
	val id: String?,
	val text: String
)

/*
Common practice in spring framework apps to implement the db access logic within the so-called service layer
-  this is where business logic lives
 */
@Service
class MessageService(val db: JdbcTemplate){
		fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
			Message(response.getString("id"), response.getString("text"))
		}

		fun save(message: Message){
			val id = message.id ?: UUID.randomUUID().toString()
			db.update(
				"insert into message values ( ?, ? )",
				message.id, message.text
			)
		}
}