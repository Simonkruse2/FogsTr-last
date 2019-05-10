/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.User;
import Data.UserMapper;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class LogicFacadeMOCK implements LogicFacade {

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
    public CarportCalcShed createSimpleCarportCalcWithShed(int length, int width) {
        return new CarportCalcShed();
    }

    

    @Override
    public User createCustomer(User u) {
        UserMapper um = new UserMapper();
        try {
            um.createCustomer(u);
        } catch (SQLException ex) {
            Logger.getLogger(LogicFacadeMOCK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogicFacadeMOCK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public User createEmployee(User u) {
           UserMapper um = new UserMapper();
        try {
            um.createEmployee(u);
        } catch (SQLException ex) {
            Logger.getLogger(LogicFacadeMOCK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogicFacadeMOCK.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

}
