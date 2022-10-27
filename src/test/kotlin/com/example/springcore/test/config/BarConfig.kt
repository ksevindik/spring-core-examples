package com.example.springcore.test.config

import com.example.springcore.test.model.Bar
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class BarConfig {
    @Bean
    fun bar() : Bar {
        return Bar()
    }
}