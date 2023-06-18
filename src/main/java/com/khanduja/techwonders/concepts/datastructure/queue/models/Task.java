package com.khanduja.techwonders.concepts.datastructure.queue.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Comparable<Task>{
    String name;
    Priority priority;

    @Override
    public int compareTo(Task task) {
        return this.priority.compareTo(task.priority);
    }
}
