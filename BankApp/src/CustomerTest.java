import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    Customer cu = new Customer("Willy", "Jeo", "65");
    @Test
    void testGetAccountNumber() {
        String num = cu.getAccountNumber();
        System.out.println(num.length());
        System.out.println("num.length()");
        assertEquals(8, num.length());
    }

    @Test
    void testGetBalance() {
        Double bal = cu.getBalance();
        assertEquals(39900, bal, 39900.0);
    }

    @Test
    void testGetIsAuth() {
        System.out.println(cu.getPIN()+ " cu.getPIN()");
        assertFalse(cu.getIsAuth());
    }


    @Test
    void testSetBalance() {
        cu.setBalance(500);
        assertEquals(500, cu.getBalance(), 500.0);
    }


    @Test
    void testSetIsAuth() {
        cu.setIsAuth(true);
        assertTrue(cu.getIsAuth());
    }

    @Test
    void testSetPIN() {
        cu.setPIN("5678");
        assertEquals("5678", cu.getPIN());
    }
}
