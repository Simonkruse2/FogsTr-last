package Logic;

import Data.Carport;
import Data.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class LogicFacade_ImplTest {

    LogicFacade_Impl logic = new LogicFacade_Impl();

    public LogicFacade_ImplTest() {
    }

    @Test
    public void createSimpleCarportTest() {
        Carport expected = new Carport(false, false, 780, 600);
        Carport actual = logic.createSimpleCarport(780, 600);
        assertEquals(expected, actual);
    }

    @Test
    public void createCustomerTest() {
        User u = new User("carl", "carl123@hotmail.com");
        u.setPhone("11223344");
        User customer = logic.createCustomer(u);
        assertNotNull(customer);
    }

    @Test
    public void createEmployeeTest() {
        User u = new User("carl", "carl123@hotmail.com");
        u.setPhone("11223344");
        User employee = logic.createCustomer(u);
        assertNotNull(employee);
    }

    @Test
    public void getCustomerTest() {
        assertNotNull(logic.getCustomer("renz@renz.dk"));
    }

}
