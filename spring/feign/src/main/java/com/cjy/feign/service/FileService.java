package com.cjy.feign.service;

import com.cjy.feign.model.NetworkFileResult;

import java.io.IOException;

public interface FileService {

    NetworkFileResult getFile(String fileId) throws IOException;
}
