package com.example.springcore.test

import com.example.springcore.test.config.BazConfig
import com.example.springcore.test.model.Baz
import com.example.springcore.test.model.Foo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@SpringBootTest
class FooTest {

    @Configuration
    @Import(BazConfig::class)
    class Config {

    }

    @TestConfiguration
    class FooConfig {
        @Bean
        fun foo() : Foo {
            return Foo()
        }
    }

    @Autowired
    private lateinit var foo: Foo

    @Autowired
    private lateinit var baz: Baz

    @Test
    fun testFooIsNotNull() {
        Assertions.assertNotNull(foo)
    }

    @Test
    fun testBazIsNotNull() {
        Assertions.assertNotNull(baz)
    }
}