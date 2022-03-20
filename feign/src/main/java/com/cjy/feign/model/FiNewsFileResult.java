package com.cjy.feign.model;

import lombok.Data;

import java.io.InputStream;

@Data
public class FiNewsFileResult {
    private Integer length;
    private InputStream input;
}
