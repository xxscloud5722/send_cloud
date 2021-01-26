package com.xxscloud.sdk.send_cloud

import com.fasterxml.jackson.databind.ObjectMapper

class SmtpApi {
    companion object {
        private val MAPPER: ObjectMapper = ObjectMapper()
    }

    private val to: ArrayList<String> = ArrayList()
    private val sub: HashMap<String, ArrayList<String>> = HashMap()


    fun add(key: String, values: List<KeyValue>): SmtpApi {
        to.add(key)
        values.forEach { (k, v) ->
            sub[k] = sub[k] ?: ArrayList()
            sub[k]?.add(v)
        }
        return this
    }

    override fun toString(): String {
        val data = HashMap<String, Any>()
        data["to"] = to
        data["sub"] = sub
        return MAPPER.writeValueAsString(data)
    }
}

