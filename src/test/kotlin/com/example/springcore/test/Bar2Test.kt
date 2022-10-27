package com.example.springcore.test

import com.example.springcore.test.config.BarConfig
import com.example.springcore.test.model.Bak
import com.example.springcore.test.model.Bar
import com.example.springcore.test.model.Bat
import com.example.springcore.test.model.Baz
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@SpringBootTest
@ContextConfiguration(classes = [BarConfig::class, Bat::class])
class Bar2Test {
    @Autowired
    private lateinit var bar: Bar

    @Autowired(required = false)
    private lateinit var baz: Baz

    @Autowired
    private lateinit var bat: Bat

    @Autowired(required = false)
    private lateinit var bak: Bak

    @Test
    fun testBarIsNotNull() {
        Assertions.assertNotNull(bar)
    }

    @Test
    fun testBazIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(baz)
        }
    }

    @Test
    fun testBatIsNotNull() {
        Assertions.assertNotNull(bat)
    }

    @Test
    fun testBakIsNull() {
        Assertions.assertThrows(UninitializedPropertyAccessException::class.java) {
            Assertions.assertNull(bak)
        }
    }
}