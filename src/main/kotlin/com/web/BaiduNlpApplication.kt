package com.web

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class BaiduNlpApplication

fun main(args: Array<String>) {
    runApplication<BaiduNlpApplication>(*args)
}
