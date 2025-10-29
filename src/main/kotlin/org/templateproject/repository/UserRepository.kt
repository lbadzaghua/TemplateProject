package org.templateproject.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.templateproject.entity.User

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}
