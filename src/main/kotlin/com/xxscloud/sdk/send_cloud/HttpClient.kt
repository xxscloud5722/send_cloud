package com.xxscloud.sdk.send_cloud

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.FormBody
import okio.IOException


object HttpClient {
    private val CLIENT = OkHttpClient.Builder().build()
    private val JSON_MAPPER: ObjectMapper = ObjectMapper()

    fun post(url: String, token: SendCloudToken, request: Any): Response {
        val body = FormBody.Builder()
                .add("apiUser", token.user)
                .add("apiKey", token.key)
        request.javaClass.methods.forEach {
            if (it.name.startsWith("get")) {
                val value = it.invoke(request) ?: return@forEach
                if (value is List<*>) {
                    if (value.isEmpty()) {
                        return@forEach
                    }
                }
                if (value.toString().isEmpty()) {
                    return@forEach
                }
                val field = it.name.substring(3, 4).toLowerCase() + it.name.substring(4)
                if (value is List<*>) {
                    body.add(field, value.joinToString(";"))
                    return@forEach
                }
                body.add(field, value.toString())
            }
        }
        val response = CLIENT.newCall(Request.Builder().url(url).post(body.build()).build()).execute()
        if (response.code != 200) {
            throw IOException(response.body?.string() ?: "")
        }
        val responseBody = response.body?.string() ?: "{}"
        return JSON_MAPPER.readValue(responseBody, Response::class.java)
    }
}