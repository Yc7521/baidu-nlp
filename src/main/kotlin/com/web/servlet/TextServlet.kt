package com.web.servlet

import com.web.util.Nlp
import com.web.util.toJson
import org.json.JSONArray
import org.json.JSONObject
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "TextServlet", value = ["/api/ai-text-emotion"])
class TextServlet : HttpServlet() {
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        super.doGet(request, response)
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val text = request.getParameter("text")
        val value = ((Nlp.query {
            sentimentClassify(
                text, null
            )
        }["items"] as JSONArray)[0] as JSONObject)["positive_prob"] as Double
        /*
            正向值>=90%：我对自己非常满意；
            80>=正向值<90：我对自己挺满意的；
            60>=正向值<80：Just so so;
            正向值<60：我对自己不怎么满意。
         */
        val json = HashMap<String, String>().apply {
            put("text", text)
            put(
                "结论", when {
                    value > 0.9 -> "我对自己非常满意"
                    value > 0.8 -> "我对自己挺满意的"
                    value > 0.6 -> "Just so so"
                    else -> "我对自己不怎么满意"
                }
            )
        }.toJson().toString()
        // set content type and utf-8
        response.contentType = "application/json;charset=utf-8"
        response.writer.print(json)
    }
}