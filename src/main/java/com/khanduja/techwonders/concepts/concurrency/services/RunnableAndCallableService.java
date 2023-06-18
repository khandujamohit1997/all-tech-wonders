package com.khanduja.techwonders.concepts.concurrency.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class RunnableAndCallableService {

    public Integer callableInterface() {
        Callable<Integer> callableTask = () -> {
            System.out.println("Executing Callable task in thread: " + Thread.currentThread().getName());
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(callableTask);

        Integer result = 0;
        try {
            result = future.get();
            System.out.println("Callable Task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            // Shutdown the ExecutorService
            executorService.shutdown();
        }
        return result;
    }

    public void runnableInterface() {
        Runnable task = () -> {
            System.out.println("Executing Runnable task in thread: " + Thread.currentThread().getName());
            for (int i = 1; i <= 5; i++) {
                System.out.println("Runnable Task result: " + i);
            }
        };

        // Create a Thread and run the task
        Thread thread = new Thread(task);
        thread.start();
    }
}
