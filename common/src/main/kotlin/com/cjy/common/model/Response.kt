package com.cjy.common.model

import com.cjy.common.enums.IResponseCode
import com.cjy.common.enums.ResponseCode

class Response<T> private constructor(
    private val code: String,
    private val msg: String,
    private val data: T?) {

    private constructor(responseCode: IResponseCode, data: T?, msg: String?) : this(
        responseCode.getCode(), msg ?: responseCode.getMsg(), data
    )

    companion object {

        @JvmStatic
        @JvmOverloads
        fun <U> success(data: U? = null, msg: String? = null): Response<U> {
            return Response(ResponseCode.SUCCESS, data, msg)
        }

        @JvmStatic
        @JvmOverloads
        fun <U> fail(responseCode: IResponseCode, data: U? = null, msg: String? = null): Response<U> {
            return Response(responseCode, data, msg)
        }
    }

    fun getCode(): String {
        return code
    }

    fun getMsg(): String {
        return msg
    }

    fun getData(): T? {
        return data
    }
}