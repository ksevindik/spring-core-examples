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
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import

@SpringBootTest
class Bar3Test {
    @TestConfiguration
    @Import(BarConfig::class, Bat::class)
    class Config {
    }

    @Autowired
    private lateinit var bat: Bat

    @Autowired
    private lateinit var bar: Bar

    @Autowired
    private lateinit var baz: Baz

    @Autowired
    private lateinit var bak: Bak

    @Test
    fun testBarIsNotNull() {
        Assertions.assertNotNull(bar)
    }

    @Test
    fun testBazIsNotNull() {
        Assertions.assertNotNull(baz)
    }

    @Test
    fun testBatIsNotNull() {
        Assertions.assertNotNull(bat)
    }


    @Test
    fun testBakIsNotNull() {
        Assertions.assertNotNull(bak)
    }
}