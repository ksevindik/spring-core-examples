package com.example.springcore.test.config

import com.example.springcore.test.model.Baz
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BazConfig {
    @Bean
    fun baz() : Baz {
        return Baz()
    }
}