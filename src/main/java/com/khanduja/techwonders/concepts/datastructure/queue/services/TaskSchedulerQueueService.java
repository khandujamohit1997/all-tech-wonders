package com.khanduja.techwonders.concepts.datastructure.queue.services;

import com.khanduja.techwonders.concepts.datastructure.queue.models.Priority;
import com.khanduja.techwonders.concepts.datastructure.queue.models.Task;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class TaskSchedulerQueueService {
    PriorityQueue<Task> taskPriorityQueue = new PriorityQueue<>();
    PriorityQueue<String> taskPriorityQueue2 = new PriorityQueue<>();

    public void enqueueTasks1() {
        taskPriorityQueue.add(new Task("Task-1", Priority.HIGH));
        taskPriorityQueue.add(new Task("Task-2", Priority.LOW));
        taskPriorityQueue.add(new Task("Task-3", Priority.MEDIUM));
        taskPriorityQueue.add(new Task("Task-4", Priority.HIGH));
    }

    public void deQueueTask1() {
        while (!taskPriorityQueue.isEmpty()) {
            Task task = taskPriorityQueue.poll();
            System.out.println(task.toString());
        }
    }

    public void enqueueTasks2() {
        taskPriorityQueue2.add("A");
        taskPriorityQueue2.add("C");
        taskPriorityQueue2.add("3");
        taskPriorityQueue2.add("B");
        taskPriorityQueue2.add("A");
        taskPriorityQueue2.add("1");
    }

    public void deQueueTask2() {
        while (!taskPriorityQueue2.isEmpty()) {
            String task = taskPriorityQueue2.poll();
            System.out.println(task);
        }
    }
}
