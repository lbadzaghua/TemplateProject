package org.templateproject.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class CustomRepositoryRestConfigurer : RepositoryRestConfigurer {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry) {
        config.isReturnBodyOnCreate = false
        config.isReturnBodyOnUpdate = false
        config.setReturnBodyOnDelete(false)

        config.setExposeRepositoryMethodsByDefault(false)
        config.isEnableEnumTranslation = false

        config.limitParamName = "limit"
        config.sortParamName = "sort"
        config.pageParamName = "offset"

        config.defaultPageSize = 20
        config.maxPageSize = 100
    }
}