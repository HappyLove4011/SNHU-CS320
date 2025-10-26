//Huan Ai
//CS 320
//10/12/2025

package Project1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactId() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        new Contact("1234567890", "JohnathanDE", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        new Contact("1234567890", "Johnathan", "Doe1234567890", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPhone() {
        new Contact("1234567890", "John", "Doe", "12345", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        new Contact("1234567890", "John", "Doe", "1234567890", "This address is way too long and exceeds 30 characters");
    }
}