package com.example.springcore.test

import com.example.springcore.test.model.Bak
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

class Sub2Test : BaseTest() {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Autowired(required = true)
    private lateinit var bak: Bak

    @TestConfiguration
    @Import(Base2Test.Base2TestConfig::class)
    class Sub2TestConfig

    @Test
    fun `message should be overriden`() {
        val message2 = applicationContext.getBean("message2",String::class)
        Assertions.assertEquals("message2",message2)
        val message = applicationContext.getBean("message",String::class)
        Assertions.assertEquals("base 2 test message",message)
    }
}