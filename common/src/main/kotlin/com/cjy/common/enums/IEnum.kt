package com.cjy.common.enums

interface IEnum<T> {
    fun getValue(): T
}

interface IResponseCode {
    fun getCode(): String
    fun getMsg(): String
}