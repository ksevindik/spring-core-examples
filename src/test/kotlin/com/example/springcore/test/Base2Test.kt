package com.example.springcore.test

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@SpringBootTest
abstract class Base2Test {
    @TestConfiguration
    class Base2TestConfig {
        @Bean
        fun message() : String = "base 2 test message"

        @Bean
        fun message2() : String = "message2"
    }
}