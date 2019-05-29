package Logic;

import Data.Carport;
import Data.Order;
import Data.User;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public interface LogicFacade {

    Carport createSimpleCarport(int length, int width);

    CarportCalc createSimpleCarportCalc(int length, int width);

    Carport createSimpleCarportWithShed(int length, int width);

    CarportCalcShed createSimpleCarportCalcWithShed(int length, int width, int shedlength, int shedwidth);

    User createCustomer(User u);

    User createEmployee(User u);

    User checkLogin(User u);

    User getCustomer(String un);

    User getEmployee(String un);

    Order createOrder(Order order);

    Order createOrderShed(Order order);

    Order getOrder(int id);

    void updatePrice(int id, int newPrice);

    void updateStatus(int id, String newStatus);
}
