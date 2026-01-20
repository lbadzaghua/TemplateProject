package org.templateproject.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.jupiter.MockitoExtension
import org.templateproject.entity.BaseIdentification
import org.templateproject.entity.User
import org.templateproject.repository.UserRepository

private const val CREATED_USER_ID = 1L

private const val EMAIL = "a@b.com"

private const val PASSWORD_HASH = "pw"

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var classUnderTest: UserService

    @BeforeEach
    fun setUp() {
        val toBeReturned = User(email = EMAIL, password = PASSWORD_HASH).also {
            BaseIdentification::class
                .java
                .getDeclaredField("id")
                .apply { isAccessible = true }
                .set(it, CREATED_USER_ID)
        }

        doReturn(toBeReturned)
            .`when`(userRepository)
            .save(any())
    }

    @Test
    fun `create user`() {
        val user = getUser()
        val result = classUnderTest.createUser(user)

        assertThat(result.id).isEqualTo(CREATED_USER_ID)
    }

    private fun getUser(): User = User(email = EMAIL, password = PASSWORD_HASH)
}