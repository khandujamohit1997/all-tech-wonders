package com.khanduja.techwonders.concepts.controller;

import com.khanduja.techwonders.concepts.concurrency.HashMapService;
import com.khanduja.techwonders.concepts.concurrency.services.CompletableFutureService;
import com.khanduja.techwonders.concepts.concurrency.services.RunnableAndCallableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/concurrent/")
public class ConcurrentController {

    @Autowired
    HashMapService hashMapService;

    @Autowired
    RunnableAndCallableService runnableAndCallableService;

    @Autowired
    CompletableFutureService completableFutureService;

    // Thread 2
    @GetMapping
    public Object getCache() {
        return hashMapService.getCacheValue("key-1");
    }

    // Thread 1
    @PostMapping
    public void addCache() {
        hashMapService.addCache("key-1", "Value-1");
    }

    @GetMapping("callable")
    public Object getCallable() {
        return runnableAndCallableService.callableInterface();
    }

    @GetMapping("runnable")
    public void getRunnable() {
        runnableAndCallableService.runnableInterface();
    }

    @GetMapping("completableFuture")
    public String getCompletableFuture() {
        return completableFutureService.completableFutureCall();
    }
}
