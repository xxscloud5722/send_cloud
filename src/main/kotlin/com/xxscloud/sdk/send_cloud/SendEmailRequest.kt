package com.xxscloud.sdk.send_cloud

data class SendEmailRequest(
        var from: String = "",
        var to: List<String> = ArrayList(),
        var subject: String = "",
        var html: String = "",
        var contentSummary: String = "",
        var fromName: String = "",
        var cc: String = "",
        var bcc: String = "",
        var replyTo: String = "",
        var labelId: String = "",
        var headers: String = "",
        var attachments: String = "",
        var xsmtpapi: String = "",
        var plain: String = "",
        var respEmailId: String = "",
        var useNotification: String = "",
        var useAddressList: String = "",
)