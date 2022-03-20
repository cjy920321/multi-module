package com.cjy.feign.service.impl;

import com.cjy.feign.model.FiNewsFileResult;
import com.cjy.feign.service.FiNewsService;
import com.cjy.feign.service.FiNewsFileService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FiNewsServiceImpl implements FiNewsService {

    private final FiNewsFileService fiNewsFileService;

    @Override
    public FiNewsFileResult getFile(String fileId) throws IOException {
        FiNewsFileResult result = new FiNewsFileResult();
        Response response = fiNewsFileService.getFile(fileId);
        result.setInput(response.body().asInputStream());
        result.setLength(Integer.parseInt(response
                .headers().get("Content-Length")
                .stream().findFirst().orElse("0")));
        return result;
    }
}
