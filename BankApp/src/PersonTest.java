import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {
    Person person = new Person("Willy", "Jeo", "65");
    @Test
    void testGetAge() {
        String age = person.getAge();
        assertEquals(age, "65");
    }

    @Test
    void testGetFirstname() {
        String firstname = person.getFirstname();
        assertEquals(firstname, "Willy");
    }

    @Test
    void testGetLastname() {
        String lastname = person.getLastname();
        assertEquals(lastname, "Jeo");
    }
}
