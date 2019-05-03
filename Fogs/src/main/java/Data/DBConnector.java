package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String URL = "jdbc:mysql://178.62.232.91/fog";
    private static final String USERNAME = "testuser2";
    private static final String PASSWORD = "password123";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

}
