package com.web.contorller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class Home {
    /**
     * 首页
     * /index
     */
    @GetMapping("/index")
    fun index(): String {
        return "index"
    }

    /**
     * 情绪查询
     * /query
     */
    @GetMapping("/query")
    fun query(): String {
        return "query"
    }

    /**
     * 课程信息
     * /course
     */
    @GetMapping("/course")
    fun course(): String {
        return "course"
    }
}