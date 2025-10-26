//Huan Ai Cs-320 10/5/2025

package org.example;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Date futureDate;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 86400000); // Tomorrow
    }

    @Test
    public void testAddAppointment() {
        // Test adding a valid appointment
        Appointment appointment = new Appointment("123", futureDate, "Test appointment");
        appointmentService.addAppointment(appointment);

        assertTrue(appointmentService.appointmentExists("123"));
        assertEquals(appointment, appointmentService.getAppointment("123"));
    }

    @Test
    public void testAddDuplicateAppointment() {
        // Test adding duplicate appointment ID
        Appointment appointment1 = new Appointment("123", futureDate, "First appointment");
        Appointment appointment2 = new Appointment("123", futureDate, "Second appointment");

        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    @Test
    public void testAddNullAppointment() {
        // Test adding null appointment
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(null);
        });
    }

    @Test
    public void testDeleteAppointment() {
        // Test deleting existing appointment
        Appointment appointment = new Appointment("123", futureDate, "Test appointment");
        appointmentService.addAppointment(appointment);

        assertTrue(appointmentService.appointmentExists("123"));
        appointmentService.deleteAppointment("123");
        assertFalse(appointmentService.appointmentExists("123"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        // Test deleting non-existent appointment
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("999");
        });
    }
}
