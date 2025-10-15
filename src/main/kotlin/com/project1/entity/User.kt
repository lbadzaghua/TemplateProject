package com.project1.entity

import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "\"user\"")
data class User(

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var password: String
)
