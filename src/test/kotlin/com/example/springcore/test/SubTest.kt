package com.example.springcore.test

import com.example.springcore.test.model.Bak
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

class SubTest : BaseTest() {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Autowired(required = true)
    private lateinit var bak: Bak

    @Test
    fun `message should not be overriden`() {
        val message2 = applicationContext.getBean("message2",String::class)
        Assertions.assertEquals("message2",message2)
        val message = applicationContext.getBean("message",String::class)
        Assertions.assertEquals("app config message",message)
    }
}