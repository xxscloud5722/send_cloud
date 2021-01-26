package com.xxscloud.sdk.send_cloud

data class Response(
        var result: String = "",
        var statusCode: Int = 0,
        var message: String = "",
        var info: Any? = null,
)