package org.templateproject.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.templateproject.entity.User
import org.templateproject.repository.CustomRepositoryError
import org.templateproject.repository.UserRepository
import java.util.*

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun getAllUsers(): List<User> {
        val findAll = userRepository.findAll()

        return findAll.toList()
    }

    fun getUserById(id: Long): Optional<User> {
        return userRepository.findById(id)
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun updateUser(id: Long, user: User): User? {
        val existingUser = userRepository.findById(id)
            .orElseThrow{ CustomRepositoryError("User with id $id not found") }

        existingUser.email = user.email
        existingUser.password = user.password

        return userRepository.save(existingUser)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
