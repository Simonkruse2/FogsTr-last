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
public class OrderMapper {
    
        public void createOrder( Order order ) throws SQLException, ClassNotFoundException {
            Connection con = DBConnector.connection();
            String SQL = "insert into `orders` (status, order_width, order_length, incline, id_customer, id_employee, price) values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, order.getStatus());
            ps.setInt( 2, order.getOrder_width());
            ps.setInt( 3, order.getOrder_length());
            ps.setInt( 4, order.getIncline());
            ps.setInt( 5, order.getId_customer());
            ps.setInt( 6, order.getId_employee());
            ps.setInt( 7, order.getPrice());
            ps.executeUpdate();
    }
}
