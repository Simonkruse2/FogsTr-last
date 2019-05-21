/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Carport;
import Data.User;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vince
 */
public class LogicFacadeMockTest {

    LogicFacadeMOCK logic = new LogicFacadeMOCK();

    public LogicFacadeMockTest() {
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
        User customer = logic.createCustomer(u);
        assertNotNull(customer);
    }
    
    @Test
    public void createEmployeeTest(){
        User u = new User("carl", "carl123@hotmail.com");
        User employee = logic.createCustomer(u);
        assertNotNull(employee);
    }
    
    @Test
    public void checkLoginTest(){
        
    }
    
}
