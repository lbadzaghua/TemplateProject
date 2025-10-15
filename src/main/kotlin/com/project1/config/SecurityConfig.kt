package com.project1.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        val securityPatterns = arrayOf(
            "/v3/api-docs/**",    // Allow access to OpenAPI docs
            "/swagger-ui/**",     // Allow access to Swagger UI
            "/swagger-ui.html",
            "/api/v1/users",
            "/api/v1/users/**"
        )

        http.authorizeHttpRequests {
            it.requestMatchers(*securityPatterns).permitAll()
            it.anyRequest().authenticated() // Secure other endpoints
        }
            .csrf { it.ignoringRequestMatchers(*securityPatterns) }


        return http.build()
    }
}