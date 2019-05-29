package Data;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class Order {

    private int id_order;
    private String status;
    private int order_width;
    private int order_length;
    private int order_width_shed;
    private int order_length_shed;
    private int incline;
    private String customer_name;
    private String employee_name;
    private int id_customer;
    private int id_employee;
    private int price;

    /**
     * this constructor contains 7 parameter.
     *
     * @param status
     * @param order_width
     * @param order_length
     * @param incline
     * @param id_customer
     * @param id_employee
     * @param price
     */
    public Order(String status, int order_width, int order_length, int incline, int id_customer, int id_employee, int price) {
        this.status = status;
        this.order_width = order_width;
        this.order_length = order_length;
        this.incline = incline;
        this.id_customer = id_customer;
        this.id_employee = id_employee;
        this.price = price;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getOrder_width_shed() {
        return order_width_shed;
    }

    public void setOrder_width_shed(int order_width_shed) {
        this.order_width_shed = order_width_shed;
    }

    public int getOrder_length_shed() {
        return order_length_shed;
    }

    public void setOrder_length_shed(int order_length_shed) {
        this.order_length_shed = order_length_shed;
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
