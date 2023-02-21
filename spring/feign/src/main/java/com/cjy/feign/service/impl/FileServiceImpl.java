package com.cjy.feign.service.impl;

import com.cjy.feign.model.NetworkFileResult;
import com.cjy.feign.service.FileService;
import com.cjy.feign.service.NetworkFileService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final NetworkFileService networkFileService;

    @Override
    public NetworkFileResult getFile(String fileId) throws IOException {
        NetworkFileResult result = new NetworkFileResult();
        Response response = networkFileService.getFile(fileId);
        result.setInput(response.body().asInputStream());
        result.setLength(Integer.parseInt(response
                .headers().get("Content-Length")
                .stream().findFirst().orElse("0")));
        return result;
    }
}
