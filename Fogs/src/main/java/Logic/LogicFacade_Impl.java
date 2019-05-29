package Logic;

import Data.Carport;
import Data.Order;
import Data.OrderException;
import Data.OrderMapper;
import Data.User;
import Data.UserMapper;
import java.sql.SQLException;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class LogicFacade_Impl implements LogicFacade {

    @Override
    public Carport createSimpleCarport(int length, int width) {
        return new Carport(false, false, length, width);
    }

    @Override
    public CarportCalc createSimpleCarportCalc(int length, int width) {
        return new CarportCalc();
    }

    @Override
    public Carport createSimpleCarportWithShed(int length, int width) {
        return new Carport(false, true, length, width);
    }

    @Override
    public CarportCalcShed createSimpleCarportCalcWithShed(int length, int width, int shedlength, int shedwidth) {
        return new CarportCalcShed();
    }

    @Override
    public User createCustomer(User u) {
        UserMapper um = new UserMapper();
        try {
            um.createCustomer(u);
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return u;
    }

    @Override
    public User createEmployee(User u) {
        UserMapper um = new UserMapper();
        try {
            um.createEmployee(u);
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return u;
    }

    @Override
    public User checkLogin(User u) {
        UserMapper um = new UserMapper();
        um.checkLogin(u.getUsername(), u.getPassword());
        return u;
    }

    @Override
    public User getCustomer(String un) {
        UserMapper um = new UserMapper();
        User u = um.getCustomer(un);
        return u;
    }

    @Override
    public User getEmployee(String un) {
        UserMapper um = new UserMapper();
        User u = um.getEmployee(un);
        return u;
    }

    @Override
    public Order createOrder(Order order) {
        OrderMapper om = new OrderMapper();
        try {
            om.createOrder(order);
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return order;
    }

    @Override
    public Order createOrderShed(Order order) {
        OrderMapper om = new OrderMapper();
        try {
            om.createOrderShed(order);
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return order;
    }

    @Override
    public Order getOrder(int id) {
        OrderMapper om = new OrderMapper();
        Order o = null;
        try {
            o = om.getOrder(id);
        } catch (OrderException ex) {
        }
        return o;
    }

    @Override
    public void updatePrice(int id, int newPrice) {
        OrderMapper om = new OrderMapper();
        try {
            om.updatePrice(id, newPrice);
        } catch (OrderException ex) {
        }
    }

    @Override
    public void updateStatus(int id, String newStatus) {
        OrderMapper om = new OrderMapper();
        try {
            om.updateStatus(id, newStatus);
        } catch (OrderException ex) {
        }
    }

}
