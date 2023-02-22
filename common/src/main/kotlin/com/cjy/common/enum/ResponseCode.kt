package com.cjy.common.enum

enum class ResponseCode(private val code: String, private val msg: String): IResponseCode {

    SUCCESS("0", "成功"),
    FAIL("-1", "未知错误"),
    FAIL_DATABASE("-1000", "内部数据库错误");

    override fun getCode(): String {
        return code
    }

    override fun getMsg(): String {
        return msg
    }

}