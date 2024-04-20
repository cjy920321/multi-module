package com.cjy.feign.controller;

import com.cjy.common.model.Response;
import com.cjy.feign.model.NetworkFileResult;
import com.cjy.feign.service.FileService;
import com.cjy.file.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("networkFile")
public class FeignController {

    private final FileService fileService;

    @GetMapping("/{fileId}")
    public Response<Float> getFile(@PathVariable String fileId) throws IOException {
        NetworkFileResult result = fileService.getFile(fileId);
        return Response.success(FileUtil.getAudioDuration(result.getInput(), result.getLength()));
    }
}
