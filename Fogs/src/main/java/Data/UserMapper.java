package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMapper {

    MD5 md5 = new MD5();

    /**
     * this method creates customers to the database.
     *
     * @param u
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void createCustomer(User u) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into "
                + "`customers` "
                + "(customer_name, phone, email) "
                + "values (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, u.getName());
        ps.setString(2, u.getPhone());
        ps.setString(3, u.getUsername());
        ps.executeUpdate();
    }

    /**
     * this method create employees to the database.
     *
     * @param u
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void createEmployee(User u) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into "
                + "`employees` (username, name, id_role, password) "
                + "values (?, ?, MD5(?));";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getName());
        ps.setString(3, u.getRole());
        ps.setString(4, u.getPassword());
        ps.executeUpdate();
    }

    /**
     * Checks whether the input username and password matches in the
     * database(mySQL).
     *
     * @param username
     * @param password input drawn from a textfield.
     * @return true for login.
     */
    public boolean checkLogin(String username, String password) {
        String _password = "";
        try {
            String SQL = "SELECT password FROM "
                    + "`employees` WHERE username = ?;";
            Connection con = DBConnector.connection();
            PreparedStatement ps
                    = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                _password = rs.getString("password");
            }
            password = md5.getMd5(password);
            return _password.equals(password);
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    /**
     * Returns a user.
     *
     * @param username is drawn from the database with a query.
     * @return the specified user.
     */
    public User getCustomer(String email) {
        User u = null;
        try {
            String SQL = "SELECT id_customer, customer_name, phone, email \n"
                    + "FROM customers \n"
                    + "WHERE email = ?;";
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String _name = rs.getString("customer_name");
                String phone = rs.getString("phone");
                String _email = rs.getString("email");
                int id = rs.getInt("id_customer");
                u = new User(_name, _email);
                u.setId(id);
                u.setPhone(phone);
            }
            return u;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }

    /**
     * this method returns an employee.
     *
     * @param un
     * @return
     */
    public User getEmployee(String un) {
        User u = null;
        try {
            String SQL = "SELECT * \n"
                    + "FROM users \n"
                    + "WHERE username = ? ;";
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, un);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                int id = rs.getInt("id_employee");
                u = new User(name, un);
                u.setRole(role);
                u.setId(id);
            }
            return u;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
}
