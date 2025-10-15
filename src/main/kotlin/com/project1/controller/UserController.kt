package com.project1.controller

import com.project1.entity.User
import com.project1.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/users")
class UserController @Autowired constructor(private val userService: UserService) {

    @Operation(
        summary = "Get all users",
        description = "Returns a list of users")
    @GetMapping("")
    fun getAllUsers(): List<User> {

        return userService.getAllUsers()
    }

    @Operation(
        summary = "Get user by ID",
        description = "Returns a user by ID")
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User?> {
        val user = userService.getUserById(id)

        return if (user.isPresent) ok(user.get()) else notFound().build()
    }

    @Operation(
        summary = "Create a new user",
        description = "Creates a new user")
    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.createUser(user)

        return created(URI.create("/api/v1/users/${createdUser.id}"))
            .body(createdUser)
    }

    @Operation(
        summary = "Update an existing user",
        description = "Updates an existing user")
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User?> {
        val updatedUser = userService.updateUser(id, user)

        return if(updatedUser != null) ok(updatedUser) else notFound().build()
    }

    @Operation(summary = "Delete a user", description = "Deletes a user by ID")
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)

        return noContent().build()
    }
}