
import Data.UserMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class UserMapperTest {

    private UserMapper handler;

    public UserMapperTest() {
        handler = new UserMapper();
    }

    @Test
    public void userMapperTest() {
        String str = "admin";
        String expected = "Carl Carlsen";
        String actual = handler.getEmployee(str).getName();

        assertEquals(actual, expected);
    }

    @Test
    public void userMapperCapsTest() {
        String str = "ADMIN";
        String expected = "admin";
        String actual = handler.getEmployee(str.toLowerCase()).getUsername();

        assertEquals(actual, expected);
    }

}
