/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author simon
 */
public class UserMapper {

    public void createCustomer(User u) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into "
                + "`customers` "
                + "(customer_name, phone, email) "
                + "values (?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, u.getName());
        ps.setString(2, u.getPhone());
        ps.setString(3, u.getEmail());
        ps.executeUpdate();
    }

    public void createEmployee(User u) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into "
                + "`employees` (name, id_role) "
                + "values (?, ?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, u.getName());
        ps.setInt(2, u.getRole());
        ps.executeUpdate();
    }

}
