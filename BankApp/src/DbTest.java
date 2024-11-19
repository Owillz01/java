import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DbTest {
    Db db = new Db();
    @Test
    void testConnect() {
        db.connect();
        assertTrue(true);
    }

    @Test
    void testInsertData() {
        db.insertData("Willy", "Jeo", "65", "23433567", "8890");
        assertTrue(true);
    }

    @Test
    void testGetCustomerInfo() {
        Customer cus = db.getCustomerInfo("23433567");
        assertEquals("Willy", cus.getFirstname());
    }


    @Test
    void testUpdateBalance() {
        Boolean update = db.updateBalance(39900.0, "23433567");
        assertTrue(update);
    }

    @Test
    void testUpdatePIN() {
        Boolean update = db.updatePIN("2390", "23433567");
        assertTrue(update);
    }
}
