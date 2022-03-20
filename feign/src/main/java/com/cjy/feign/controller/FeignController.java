package com.cjy.feign.controller;

import com.cjy.common.model.Response;
import com.cjy.feign.model.FiNewsFileResult;
import com.cjy.feign.service.FiNewsService;
import com.cjy.file.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("fiNews")
public class FeignController {

    private final FiNewsService fiNewsService;

    @GetMapping("/{fileId}")
    public Response<Float> getFile(@PathVariable String fileId) throws IOException {
        FiNewsFileResult result = fiNewsService.getFile(fileId);
        return Response.success(FileUtil.getAudioDuration(result.getInput(), result.getLength()));
    }
}
