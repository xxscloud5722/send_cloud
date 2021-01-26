package com.xxscloud.sdk.send_cloud

data class SendTemplateEmailRequest(
        var from: String = "",
        var to: List<String> = ArrayList(),
        var subject: String = "",
        var templateInvokeName: String = "",
        var contentSummary: String = "",
        var fromName: String = "",
        var cc: String = "",
        var bcc: String = "",
        var replyTo: String = "",
        var labelId: String = "",
        var headers: String = "",
        var attachments: String = "",
        var xsmtpapi: SmtpApi? = null,
        var respEmailId: String = "",
        var useNotification: String = "",
        var useAddressList: String = "",
)