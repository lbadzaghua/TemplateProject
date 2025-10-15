package com.project1

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Project1Application

fun main(args: Array<String>) {
    runApplication<Project1Application>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}