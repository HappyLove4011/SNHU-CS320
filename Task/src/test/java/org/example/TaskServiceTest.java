//Huan Ai
//CS 320
//9/28/2025

package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Test Name", "Test Description");
        service.addTask(task);

        assertNotNull(service.getTask("1234567890"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateTasks() {
        TaskService service = new TaskService();
        Task task1 = new Task("1234567890", "Test Name", "Test Description");
        Task task2 = new Task("1234567890", "Test Name", "Test Description");

        service.addTask(task1);
        service.addTask(task2); // Should throw exception
    }

    @Test
    public void testDeleteContact() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Test Name", "Test Description");
        service.addTask(task);

        service.deleteTask("1234567890");
        assertNull(service.getTask("1234567890"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentContact() {
        TaskService service = new TaskService();
        service.deleteTask("nonexistent");
    }

    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        Task task = new Task("1234567890", "Test Name", "Test Description");
        service.addTask(task);

        service.updateName("1234567890", "Jane");
        service.updateDescription("1234567890", "Smith");


        Task updated = service.getTask("1234567890");
        assertEquals("Jane", updated.getName());
        assertEquals("Smith", updated.getDescription());
    }
}