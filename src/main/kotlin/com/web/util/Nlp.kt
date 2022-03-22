package com.web.util

import com.baidu.aip.nlp.AipNlp
import org.json.JSONObject

object Nlp {
    //设置APPID/AK/SK
    const val APP_ID = "25815701"
    const val API_KEY = "1CYntctCskxp46Xvav06IYdD"
    const val SECRET_KEY = "7k8Vg3ANLj7hTVaGwb7MhZwwxqFV5Ceg"

    inline fun query(func: AipNlp.() -> JSONObject): JSONObject {
        // 初始化一个AipNlp
        val client: AipNlp = AipNlp(APP_ID, API_KEY, SECRET_KEY)

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000)
        client.setSocketTimeoutInMillis(60000)

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        // client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        // client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        return client.func()
    }
}