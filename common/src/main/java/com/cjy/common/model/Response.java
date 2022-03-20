package com.cjy.common.model;

import com.cjy.common.enums.IResponseCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {

    private String code;
    private String msg;
    private T data;

    private Response(IResponseCode responseCode) {
        this(responseCode, null);
    }

    private Response(IResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.data = data;
    }

    private Response(IResponseCode responseCode, T data, String msg) {
        this.code = responseCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    public static <K> Response<K> success() {
        return new Response<>(ResponseCode.SUCCESS);
    }

    public static <K> Response<K> success(K data) {
        return new Response<>(ResponseCode.SUCCESS, data);
    }

    public static <K> Response<K> success(K data, String msg) {
        return new Response<>(ResponseCode.SUCCESS, data, msg);
    }

    public static <K> Response<K> fail(IResponseCode responseCode) {
        return new Response<>(responseCode);
    }

    public static <K> Response<K> fail(IResponseCode responseCode, K data) {
        return new Response<>(responseCode, data);
    }

    public static <K> Response<K> fail(IResponseCode responseCode, K data, String msg) {
        return new Response<>(responseCode, data, msg);
    }
}
