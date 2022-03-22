package com.web.servlet

import cn.edu.njuit.web.server.CourseTool
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "CourseServlet", value = ["/api/course-info"])
class CourseServlet : HttpServlet() {
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val text = CourseTool().webCourse.toString()
        response.contentType = "text/html;charset=utf-8"
        response.writer.write(text)
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        super.doPost(request, response)
    }
}