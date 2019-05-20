/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author simon
 */
public class OrderMapper {

    public void createOrder(Order order) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into `orders` (status, order_width, order_length, incline, "
                + "id_customer, id_employee, price) values (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, order.getStatus());
        ps.setInt(2, order.getOrder_width());
        ps.setInt(3, order.getOrder_length());
        ps.setInt(4, order.getIncline());
        ps.setInt(5, order.getId_customer());
        ps.setInt(6, order.getId_employee());
        ps.setInt(7, order.getPrice());
        ps.executeUpdate();
    }

    public void createOrderShed(Order order) throws SQLException, ClassNotFoundException {
        Connection con = DBConnector.connection();
        String SQL = "insert into `orders` (status, order_width, "
                + "order_length, order_width_shed, order_length_shed, incline,"
                + " id_customer, id_employee, price) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, order.getStatus());
        ps.setInt(2, order.getOrder_width());
        ps.setInt(3, order.getOrder_length());
        ps.setInt(4, order.getOrder_width_shed());
        ps.setInt(5, order.getOrder_length_shed());
        ps.setInt(6, order.getIncline());
        ps.setInt(7, order.getId_customer());
        ps.setInt(8, order.getId_employee());
        ps.setInt(9, order.getPrice());
        ps.executeUpdate();
    }

//    public Order getOrder(Order order) {
//        User u = null;
//        try {
//            String query = "SELECT * \n"
//                    + "FROM users \n"
//                    + "WHERE username = '" + un + "';";
//            Connection con = DBConnector.connection();
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String role = rs.getString("role");
//                u = new User(name, un);
//                u.setRole(role);
//            }
//            return u;
//        } catch (Exception ex) {
//            System.out.println("Den henter ingen bruger");
//            ex.printStackTrace();
//            return null;
//        }
//    }
}
