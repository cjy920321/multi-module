package com.cjy.feign.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.fi-news")
public class FiNewsConfig {

    private String fileUrl;
}
