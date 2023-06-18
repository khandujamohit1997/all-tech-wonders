package com.khanduja.techwonders.concepts.controller;

import com.khanduja.techwonders.concepts.datastructure.queue.services.TaskSchedulerQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/queue")
public class QueueController {

    @Autowired
    TaskSchedulerQueueService taskSchedulerQueueService;

    // Thread 1
    @GetMapping
    public void enAndDeQueue() {
        taskSchedulerQueueService.enqueueTasks1();
        taskSchedulerQueueService.deQueueTask1();
        taskSchedulerQueueService.enqueueTasks2();
        taskSchedulerQueueService.deQueueTask2();
    }
}
