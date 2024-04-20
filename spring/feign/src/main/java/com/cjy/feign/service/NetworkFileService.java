package com.cjy.feign.service;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "networkFile", url = "${app.file.url}")
@Service
public interface NetworkFileService {

    @GetMapping("/{fileId}")
    Response getFile(@PathVariable("fileId") String fileId);
}
