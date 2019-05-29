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
import java.util.ArrayList;

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

    public ArrayList<Order> getOrders() throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `ordersview`;";
            ArrayList<Order> orders = new ArrayList<>();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                int id_order = rs.getInt("id_order");
                String status = rs.getString("status");
                int order_width = rs.getInt("order_width");
                int order_length = rs.getInt("order_length");
                int incline = rs.getInt("incline");
                String customer_name = rs.getString("customer_name");
                int id_customer = rs.getInt("id_customer");
                String employee_name = rs.getString("name");
                int id_employee = rs.getInt("id_employee");
                int price = rs.getInt("price");
                int order_width_shed = rs.getInt("order_width_shed");
                int order_length_shed = rs.getInt("order_length_shed");
                Order o = new Order(status, order_width, order_length, incline, id_customer, id_employee, price);
                o.setId_order(id_order);
                o.setOrder_width_shed(order_width_shed);
                o.setOrder_length_shed(order_length_shed);
                o.setCustomer_name(customer_name);
                o.setEmployee_name(employee_name);
                orders.add(o);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public Order getOrder(int id) throws OrderException {
        Order o = null;
        try {
            Connection con = DBConnector.connection();
            String SQL = "select * from `ordersview` where id_order = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_order = rs.getInt("id_order");
                String status = rs.getString("status");
                int order_width = rs.getInt("order_width");
                int order_length = rs.getInt("order_length");
                int incline = rs.getInt("incline");
                int id_customer = rs.getInt("id_customer");
                String customer_name = rs.getString("customer_name");
                int id_employee = rs.getInt("id_employee");
                String employee_name = rs.getString("name");
                int price = rs.getInt("price");
                int order_width_shed = rs.getInt("order_width_shed");
                int order_length_shed = rs.getInt("order_length_shed");
                o = new Order(status, order_width, order_length, incline, id_customer, id_employee, price);
                o.setId_order(id_order);
                o.setOrder_width_shed(order_width_shed);
                o.setOrder_length_shed(order_length_shed);
                o.setCustomer_name(customer_name);
                o.setEmployee_name(employee_name);
            }
            return o;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public void updatePrice(int id, int newPrice) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "UPDATE `orders` SET `price` = ? where id_order = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, newPrice);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public void updateStatus(int id, String newStatus) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "UPDATE `orders` SET `status` = ? where id_order = ?;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, newStatus);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

}
