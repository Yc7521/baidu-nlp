package com.web

import com.web.util.Nlp
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BaiduNlpApplicationTests {

    @Test
    fun contextLoads() {
        println(Nlp.query { lexer("百度是一家高科技公司", null) }.toString(2))
    }
}
