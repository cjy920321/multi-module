package com.cjy.common.model;

import com.cjy.common.enums.IResponseCode;

public enum ResponseCode implements IResponseCode {
    SUCCESS("0", "成功"),
    FAIL("-1", "未知错误"),
    FAIL_DATABASE("-1000", "内部数据库错误");

    private final String code;
    private final String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
