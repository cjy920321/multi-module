package com.cjy.task.config;

import com.cjy.common.util.BeanUtil;
import com.cjy.task.config.properties.QuartzTaskProperties;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@Slf4j
public class QuartzConfig {

    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactory, QuartzTaskProperties quartzTaskProperties) {
        Scheduler scheduler = schedulerFactory.getScheduler();
        if (quartzTaskProperties.getCron() != null) {
            quartzTaskProperties.getCron().forEach((key, task) -> {
                try {
                    scheduler.addJob(jobDetail(task.getJobClass(), key), true);
                    scheduler.scheduleJob(trigger(task.getJobClass(), task.getExpress(), key));
                } catch (SchedulerException | ClassNotFoundException e) {
                    log.error("定时任务初始化失败：" + e);
                }
            });
        }
        return scheduler;
    }

    @SuppressWarnings("unchecked")
    private JobDetail jobDetail(String className, String jobName) throws ClassNotFoundException {
        Class<? extends Job> clazz = (Class<? extends Job>) Class.forName(className);
        return JobBuilder.newJob(BeanUtil.getBean(clazz).getClass()).withIdentity(jobName).storeDurably().build();
    }

    private Trigger trigger(String className, String express, String name) throws ClassNotFoundException {
        return TriggerBuilder.newTrigger().forJob(jobDetail(className, name))
                .withIdentity(name)
                .withSchedule(CronScheduleBuilder.cronSchedule(express))
                .build();
    }
}
