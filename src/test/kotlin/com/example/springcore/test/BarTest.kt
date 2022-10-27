package com.example.springcore.test

import com.example.springcore.test.model.Bak
import com.example.springcore.test.model.Bat
import com.example.springcore.test.model.Baz
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Configuration

@SpringBootTest
class BarTest {
    @Configuration
    class Config {
    }

    @Autowired(required = false)
    private lateinit var foo:String

    @Autowired(required = false)
    private lateinit var bar:String

    @Autowired(required = false)
    private lateinit var bat: Bat

    @Autowired(required = false)
    private lateinit var baz: Baz

    @Autowired(required = false)
    private lateinit var bak: Bak

    @Test
    fun testFooIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(foo)
        }
    }

    @Test
    fun testBarIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(bar)
        }
    }

    @Test
    fun testBazIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(baz)
        }
    }

    @Test
    fun testBatIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(bat)
        }
    }

    @Test
    fun testBakIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(bak)
        }
    }
}