package org.templateproject.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Size

@Entity
@Table(name = "\"user\"")
class User(

    @field:Email
    @field:Size(min = 5, max = 250)
    @Column(nullable = false, unique = true)
    var email: String,

    @field:Size(min = 16, max = 128)
    @Column(nullable = false)
    var password: String

) : BaseIdentification()
