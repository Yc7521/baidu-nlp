package com.web.contorller
//
//import cn.edu.njuit.web.server.CourseTool
//import com.web.util.Nlp
//import com.web.util.toJson
//import org.json.JSONArray
//import org.json.JSONObject
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/api")
//class Api {
//    @PostMapping("/ai-text")
//    fun aiText(text: String): String {
//        return Nlp.query { sentimentClassify(text, null) }.toString()
//    }
//
//    @PostMapping("/ai-lexer")
//    fun aiLexer(text: String): String {
//        return Nlp.query { lexer(text, null) }.toString()
//    }
//
//    @PostMapping("/ai-text-emotion")
//    fun aiTextEmotion(text: String): String {
//        val value = ((Nlp.query {
//            sentimentClassify(
//                text, null
//            )
//        }["items"] as JSONArray)[0] as JSONObject)["positive_prob"] as Double
//        /*
//            正向值>=90%：我对自己非常满意；
//            80>=正向值<90：我对自己挺满意的；
//            60>=正向值<80：Just so so;
//            正向值<60：我对自己不怎么满意。
//         */
//        return HashMap<String, String>().apply {
//            put("text", text)
//            put(
//                "结论", when {
//                    value > 0.9 -> "我对自己非常满意"
//                    value > 0.8 -> "我对自己挺满意的"
//                    value > 0.6 -> "Just so so"
//                    else -> "我对自己不怎么满意"
//                }
//            )
//        }.toJson()
//    }
//
//    @GetMapping("/course-info")
//    fun courseInfo(): String {
//        return CourseTool().webCourse.toString()
//    }
//
//}