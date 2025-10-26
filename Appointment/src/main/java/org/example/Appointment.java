//Huan Ai Cs-320 10/5/2025

package org.example;
import java.util.Date;


public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        // Validate Appointment ID
        if (appointmentID == null || appointmentID.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be not null and cannot exceed 10 characters");
        }
        this.appointmentID = appointmentID;

        // Validate and set description
        setDescription(description);

        // Validate and set appointment date
        setAppointmentDate(appointmentDate);
    }

    // Getters
    public String getAppointmentId() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }


    // Setters
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and cannot exceed 50 characters");
        }
        this.description = description;
    }

    // Setters with validation
    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date cannot be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        this.appointmentDate = appointmentDate;
    }

}
