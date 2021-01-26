package com.xxscloud.sdk.send_cloud

import org.slf4j.LoggerFactory

class SCEmail constructor(
        private val token: SendCloudToken
) {
    companion object {
        private const val BAST_URL = "https://api.sendcloud.net/apiv2"
        private val log = LoggerFactory.getLogger(SCEmail::class.java)
    }

    /**
     * 发送普通邮件.
     * @param request SendEmailRequest 邮件信息.
     * @return Boolean 是否发送成功.
     */
    fun send(request: SendEmailRequest): Boolean {
        if (request.from.isEmpty() || request.to.isEmpty() || request.html.isEmpty()) {
            log.error("URL: https://www.sendcloud.net/doc/email_v2/send_email/#_1")
            throw RuntimeException("request error")
        }
        val response = HttpClient.post("$BAST_URL/mail/send", token, request)
        if (response.statusCode != 200) {
            throw RuntimeException(response.message)
        }
        return true
    }


    /**
     * 通过模板发送邮件.
     * @param request SendTemplateEmailRequest 邮件信息.
     * @return Boolean 是否发送成功.
     */
    fun sendTemplate(request: SendTemplateEmailRequest): Boolean {
        if (request.from.isEmpty() || request.to.isEmpty() || request.templateInvokeName.isEmpty()) {
            log.error("URL: https://www.sendcloud.net/doc/email_v2/send_email/#_2")
            throw RuntimeException("request error")
        }
        val response = HttpClient.post("$BAST_URL/mail/sendtemplate", token, request)
        if (response.statusCode != 200) {
            throw RuntimeException(response.message)
        }
        return true
    }

}