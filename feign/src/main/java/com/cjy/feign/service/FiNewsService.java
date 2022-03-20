package com.cjy.feign.service;

import com.cjy.feign.model.FiNewsFileResult;

import java.io.IOException;

public interface FiNewsService {

    FiNewsFileResult getFile(String fileId) throws IOException;
}
