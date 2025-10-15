package com.project1.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class CustomRepositoryRestConfigurer : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry) {
        config.setReturnBodyOnCreate(false)
        config.setReturnBodyOnUpdate(false)
        config.setReturnBodyOnDelete(false)

        config.setExposeRepositoryMethodsByDefault(false)
        config.setEnableEnumTranslation(false)

        config.setLimitParamName("limit")
        config.setSortParamName("sort")
        config.setPageParamName("offset")

        config.setDefaultPageSize(20)
        config.setMaxPageSize(100)
    }
}