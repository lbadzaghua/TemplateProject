package com.templateproject

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TemplateProjectApplication

fun main(args: Array<String>) {
    runApplication<TemplateProjectApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}