//Huan Ai
//CS 320
//10/12/2025

package Project1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1234567890", "Test Name", "Test Description");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Test Name", task.getName());
        assertEquals("Test Description", task.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaskId() {
        new Task("12345678901", "Test Name", "Test Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidName() {
        new Task("1234567890", "Ai1234567891011121314151617181920", "Test Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDescription() {
        new Task("1234567890", "John", "The quick brown fox jumps over the lazy dog near the bubbling brook.");
    }


}