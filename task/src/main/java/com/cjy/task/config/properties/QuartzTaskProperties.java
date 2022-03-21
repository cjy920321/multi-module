package com.cjy.task.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "app.task")
public class QuartzTaskProperties {

    private Map<String, CronTaskProperties> cron;
}
