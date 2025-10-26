//Huan Ai
//CS 320
//10/12/2025

package Project1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        assertNotNull(service.getContact("1234567890"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Oak St");

        service.addContact(contact1);
        service.addContact(contact2); // Should throw exception
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        service.deleteContact("nonexistent");
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.updateFirstName("1234567890", "Jane");
        service.updateLastName("1234567890", "Smith");
        service.updatePhone("1234567890", "0987654321");
        service.updateAddress("1234567890", "456 Oak St");

        Contact updated = service.getContact("1234567890");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Oak St", updated.getAddress());
    }
}