package com.cjy.feign.service;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fiNewsFile", url = "${app.fi-news.file-url}")
@Service
public interface FiNewsFileService {

    @GetMapping("/{fileId}")
    Response getFile(@PathVariable String fileId);
}
