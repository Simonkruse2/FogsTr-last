/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author simon
 */
public class Order {

    private String status;
    private int order_width;
    private int order_length;
    private int incline;
    private int id_customer;
    private int id_employee;
    private int price;

    public Order(String status, int order_width, int order_length, int incline, int id_customer, int id_employee, int price) {
        this.status = status;
        this.order_width = order_width;
        this.order_length = order_length;
        this.incline = incline;
        this.id_customer = id_customer;
        this.id_employee = id_employee;
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrder_width() {
        return order_width;
    }

    public void setOrder_width(int order_width) {
        this.order_width = order_width;
    }

    public int getOrder_length() {
        return order_length;
    }

    public void setOrder_length(int order_length) {
        this.order_length = order_length;
    }

    public int getIncline() {
        return incline;
    }

    public void setIncline(int incline) {
        this.incline = incline;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" + "status=" + status + ", order_width=" + order_width + ", order_length=" + order_length + ", incline=" + incline + ", id_customer=" + id_customer + ", id_employee=" + id_employee + ", price=" + price + '}';
    }
        
}
