//Huan Ai
//CS 320
//9/28/2025

package org.example;

public class Task {
    private final String taskID;
    private String Name;
    private String Description;

    public Task(String taskID, String Name, String Description) {
        // Validate task ID
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must be not null and cannot exceed 10 characters");
        }

        // Validate name
        if (Name == null || Name.length() > 20) {
            throw new IllegalArgumentException("Task Name must be not null and cannot exceed 20 characters");
        }

        // Validate description
        if (Description == null || Description.length() > 50) {
            throw new IllegalArgumentException("Task Description must be not null and cannot exceed 50 characters");
        }


        this.taskID = taskID;
        this.Name = Name;
        this.Description = Description;
    }
    // Getters
    public String getTaskId() { return taskID; }
    public String getName() { return Name; }
    public String getDescription() { return Description; }

    // Setters (only for updatable fields)
    public void setName(String Name) {
        if (Name == null || Name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null or exceed 20 characters");
        }
        this.Name = Name;
    }

    public void setDescription(String Description) {
        if (Description == null || Description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null or exceed 50 characters");
        }
        this.Description = Description;
    }

}