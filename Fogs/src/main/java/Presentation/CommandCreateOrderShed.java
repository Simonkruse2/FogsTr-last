/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Carport;
import Data.Order;
import Data.OrderMapper;
import Data.User;
import Data.UserMapper;
import Logic.CarportCalcShed;
import Logic.LogicFacade;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author simon
 */
public class CommandCreateOrderShed extends Command {

    public CommandCreateOrderShed() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OrderMapper om = new OrderMapper();
        UserMapper um = new UserMapper();

        User u = (User) session.getAttribute("user");
        Carport carport = (Carport) session.getAttribute("carport");
        CarportCalcShed calcShed = (CarportCalcShed) session.getAttribute("CarportCalcShed");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        User customer = new User(name, email);
        customer.setPhone(phone);
        logic.createCustomer(customer);
        customer.setId(um.getCustomer(customer.getUsername()).getId());
        Order o = new Order("Shipped", carport.getWidthOuter(), carport.getLengthOuter(), 0,
                customer.getId(), u.getId(), calcShed.getPrice());
        o.setOrder_width_shed(carport.getShedwidth());
        o.setOrder_length_shed(carport.getShedlength());
        
        try {
            om.createOrderShed(o);
        } catch (SQLException ex) {
            Logger.getLogger(CommandCreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommandCreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index.jsp";
    }

}
