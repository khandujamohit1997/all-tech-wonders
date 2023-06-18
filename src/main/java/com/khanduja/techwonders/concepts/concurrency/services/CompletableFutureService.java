package com.khanduja.techwonders.concepts.concurrency.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class CompletableFutureService {

    public String completableFutureCall() {
        // Create a CompletableFuture for an asynchronous computation
        CompletableFuture<String> futureTask = CompletableFuture.supplyAsync(() -> {
            // Simulate a time-consuming task
            try {
                Thread.sleep(4000);
                System.out.println("Task1: Processing result in thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, CompletableFuture!";
        });

        CompletableFuture<String> processedTask = futureTask.thenApplyAsync(result -> {
            try {
                Thread.sleep(6000);
                System.out.println("Task2: Processing result in thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Processed :" + result;
        });

        System.out.println("Task3: Processing result in thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Register a callback to handle the result when the computation is complete
        futureTask.thenAccept(result -> System.out.println("Result: " + result));
        processedTask.thenAccept(result -> System.out.println("Result: " + result));


        // Perform other tasks while the CompletableFuture is running asynchronously
        System.out.println("Task4: Processing result in thread: " + Thread.currentThread().getName());

        // Block and wait for the CompletableFuture to complete and retrieve the result
        String result = null;
        String result1;
        try {
            result = futureTask.get();
            result1 = processedTask.get();
            System.out.println("CompletableFuture Final Result: " + result + " : " + result1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
