package com.example.springcore.test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootTest
abstract class BaseTest {
    @TestConfiguration
    class BaseTestConfig {
        @Bean
        fun message() : String = "base test message"

        @Bean
        fun message2() : String = "message2"
    }
}