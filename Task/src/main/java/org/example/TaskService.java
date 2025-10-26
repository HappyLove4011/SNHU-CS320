//Huan Ai
//CS 320
//9/28/2025

package org.example;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<String, Task> tasks = new HashMap<>();

    // Add task with unique ID
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete task by ID
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID not found");
        }
        tasks.remove(taskId);
    }

    // Update task fields
    public void updateName(String taskId, String Name) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID not found");
        }
        task.setName(Name);
    }

    public void updateDescription(String taskId, String Description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        task.setDescription(Description);
    }

    // Helper method for testing
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
