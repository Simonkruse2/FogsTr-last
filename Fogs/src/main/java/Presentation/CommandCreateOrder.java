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
import Logic.CarportCalc;
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
public class CommandCreateOrder extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, OrderException{
        HttpSession session = request.getSession();
        OrderMapper om = new OrderMapper();
        UserMapper um = new UserMapper();
try {
        User u = (User) session.getAttribute("user");
        Carport carport = (Carport) session.getAttribute("carport");
        CarportCalc calc = (CarportCalc) session.getAttribute("CarportCalc");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        User customer = new User(name, email);
        
        if(name == null || "".equals(name) )
            throw new OrderException("Name must be filled out");
        for(int i = 0; i < name.length(); i++){
            if(name.indexOf(i) == -1)
            throw new OrderException("Name can't contain numbers or signs");
        }

        if(phone == null || "".equals(phone) )
            throw new OrderException("Phonenumber must be filled out");
        if(!phone.matches(".*\\d.*"))
            throw new OrderException("Phone can't contain letters or signs");

        if(email == null || "".equals(email) )
            throw new OrderException("E-mail must be filled out");
        if(!(email.contains("@")) && !(email.contains(".")))
            throw new OrderException("Incorrect e-mail");
        
        customer.setPhone(phone);
        logic.createCustomer(customer);
        customer.setId(um.getCustomer(customer.getUsername()).getId());
        Order o = new Order("In progress", carport.getWidthOuter(), carport.getLengthOuter(), 0,
                customer.getId(), u.getId(), calc.getPrice());
                    om.createOrder(o);
        } catch (OrderException oe) {
            session.setAttribute("error", oe.getMessage());
            return "Partlists.jsp"; 
        } catch (SQLException ex) {
            return "Partlists.jsp";
        } catch (ClassNotFoundException ex) {
            return "Partlists.jsp";
        } 
        return "index.jsp";
    }

}
