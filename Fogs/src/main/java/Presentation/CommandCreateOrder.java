/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

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

/**
 *
 * @author simon
 */
public class CommandCreateOrder extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        User u = null;
        u.setName(request.getParameter("name"));
        u.setPhone(request.getParameter("phone"));
        u.setUsername(request.getParameter("email"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int shedlength = Integer.parseInt(request.getParameter("shedlength"));
        int shedwidth = Integer.parseInt(request.getParameter("shedlength"));
        CarportCalcShed calcShed = (CarportCalcShed) request.getAttribute("carportCalcShed");
        OrderMapper om = new OrderMapper();
        UserMapper um = new UserMapper();
        Order o = new Order("Shipped", width, length, shedwidth, shedlength,
                um.getCustomer(u.getUsername()).getId(), calcShed.getPrice());
        try {
            om.createOrder(o);
        } catch (SQLException ex) {
            Logger.getLogger(CommandCreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommandCreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        logic.createCustomer(u);
        return "index.jsp";

    }

}
