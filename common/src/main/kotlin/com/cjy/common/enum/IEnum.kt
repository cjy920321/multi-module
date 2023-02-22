package com.cjy.common.enum

interface IEnum<T> {
    fun getValue(): T
}

interface IResponseCode {
    fun getCode(): String
    fun getMsg(): String
}