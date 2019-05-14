/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author simon
 */
public class UserMapper {

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCustomer(User u) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into "
                + "`customers` "
                + "(customer_name, phone, email, password) "
                + "values (?, ?, ?, MD5(?))";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, u.getName());
        ps.setString(2, u.getPhone());
        ps.setString(3, u.getEmail());
        ps.setString(4, u.getPassword());
        ps.executeUpdate();
    }

    public void createEmployee(User u) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into "
                + "`employees` (name, id_role, password) "
                + "values (?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, u.getName());
        ps.setInt(2, u.getRole());
        ps.setString(3, u.getPassword());
        ps.executeUpdate();
    }

    /**
     * Checks whether the input username and password matches in the
     * database(mySQL).
     *
     * @param email input drawn from a textfield.
     * @param password input drawn from a textfield.
     * @return true for login.
     */
    public boolean checkLogin(String email, String password) {
        String _password = "";
        try {
            DBConnector c = new DBConnector();
            String query = "SELECT password FROM `customers` WHERE email = '" + email + "';";
            Connection con = DBConnector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                _password = rs.getString("password");
                password = getMd5(password);
//                String passwordDecrypted = "select MD5('" + _password + "')";
//                System.out.println(passwordDecrypted);
//                System.out.println(_password + "decrypted");
            }
//            System.out.println(query);
            return _password.equals(password);
        } catch (Exception ex) {
//            System.out.println(_password + "Den henter intet password");
            ex.printStackTrace();
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
            DBConnector c = new DBConnector();

            String query = "SELECT customer_name, phone, email \n"
                    + "FROM customers \n"
                    + "WHERE email = '" + email + "';";
            Connection con = DBConnector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String _name = rs.getString("customer_name");
                String phone = rs.getString("phone");
                String _email = rs.getString("email");
                u = new User(_name, phone, _email);
            }
            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
        public User getEmployee(String email) {
        User u = null;
        try {
            DBConnector c = new DBConnector();

            String query = "SELECT customer_name, phone, email \n"
                    + "FROM employees \n"
                    + "WHERE email = '" + email + "';";
            Connection con = DBConnector.connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String _name = rs.getString("customer_name");
                String phone = rs.getString("phone");
                String _email = rs.getString("email");
                u = new User(_name, phone, _email);
            }
            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
