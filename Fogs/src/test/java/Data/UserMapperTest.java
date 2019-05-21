package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.UserMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renz
 */
public class UserMapperTest {
    private UserMapper handler;
    
    public UserMapperTest() {
    handler = new UserMapper();    
    }
    
    @Test
    public void userMapperTest(){
        String str = "carl123";
        String expected = "Carl";
        String actual = handler.getEmployee(str).getName();
        
        assertEquals(actual, expected);
    }
    @Test
    public void userMapperCapsTest(){
        String str = "CARL123";
        String expected = "carl123";
        String actual = handler.getEmployee(str.toLowerCase()).getUsername();
        
        assertEquals(actual, expected);
    }
    
    
}
