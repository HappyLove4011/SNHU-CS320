//Huan Ai Cs-320 10/5/2025

package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentCreation() {
        // Test valid appointment creation
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // Tomorrow
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description");

        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Valid description", appointment.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        new Appointment("12345678901", futureDate, "Doe");
    }

    @Test
    public void testAppointmentDateValidation() {
        // Test null appointment date
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", null, "Description");
        });

        // Test past appointment date
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // Yesterday
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "Description");
        });

        // Test setting past date after creation
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment("123", futureDate, "Description");
        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(pastDate);
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        new Appointment("123456789", futureDate, "This description is definitely longer than fifty characters long");
    }
}
