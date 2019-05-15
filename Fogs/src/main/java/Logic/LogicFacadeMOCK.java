/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.User;
import Data.UserMapper;
import java.sql.SQLException;

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
            System.out.println("SQLException ... øv");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return u;
    }

    @Override
    public User createEmployee(User u) {
        UserMapper um = new UserMapper();
        try {
            um.createEmployee(u);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException ... øv");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Class not found");
        }
        return u;
    }

    @Override
    public User checkLogin(User u) {
        UserMapper um = new UserMapper();
        um.checkLogin(u.getUsername(),u.getPassword());
        return u;
    }

    @Override
    public User getEmployee(String un) {
        UserMapper um = new UserMapper();
        User u = um.getEmployee(un);
        return u;
    }
}
