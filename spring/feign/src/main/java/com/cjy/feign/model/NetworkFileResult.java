package com.cjy.feign.model;

import lombok.Data;

import java.io.InputStream;

@Data
public class NetworkFileResult {
    private Integer length;
    private InputStream input;
}
