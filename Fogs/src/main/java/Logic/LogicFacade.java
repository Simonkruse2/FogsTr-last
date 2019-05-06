/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.User;

/**
 *
 * @author simon
 */
public interface LogicFacade {
    
    Carport createSimpleCarport(int length, int width);
    CarportCalc createSimpleCarportCalc(int length, int width);
    User createCustomer(User u);
    User createEmployee(User u);
}
