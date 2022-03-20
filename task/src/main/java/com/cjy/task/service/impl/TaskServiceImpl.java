package com.cjy.task.service.impl;

import com.cjy.task.job.BaseJob;
import com.cjy.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final Scheduler scheduler;
    private final BaseJob baseJob;


}
