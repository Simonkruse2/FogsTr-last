/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Carport;
import Data.Order;
import Data.User;

/**
 *
 * @author simon
 */
public interface LogicFacade {
    
    Carport createSimpleCarport(int length, int width);
    CarportCalc createSimpleCarportCalc(int length, int width);
    Carport createSimpleCarportWithShed(int length, int width);
    CarportCalcShed createSimpleCarportCalcWithShed(int length, int width, int shedlength, int shedwidth);
    User createCustomer(User u);
    User createEmployee(User u);
    User checkLogin(User u);
    User getEmployee(String un);
    Order createOrder(Order order);
}
