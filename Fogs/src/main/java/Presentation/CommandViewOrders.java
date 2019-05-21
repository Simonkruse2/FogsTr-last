/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Order;
import Data.OrderException;
import Data.OrderMapper;
import Logic.LogicFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author simon
 */
public class CommandViewOrders extends Command {

    public CommandViewOrders() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));

//            o = new Order(om.getOrder(id).getStatus(), om.getOrder(id).getOrder_width(),
//                    om.getOrder(id).getOrder_length(), om.getOrder(id).getIncline(),
//                    om.getOrder(id).getId_customer(), om.getOrder(id).getId_employee(),
//                    om.getOrder(id).getPrice());
//            
        /* logic.getOrder(id) = new Order(logic.getOrder(id).getStatus(), logic.getOrder(id).getOrder_width(),
                logic.getOrder(id).getOrder_length(), logic.getOrder(id).getIncline(), logic.getOrder(id).getId_customer(),
                logic.getOrder(id).getId_employee(), logic.getOrder(id).getPrice());
        int length = o.getOrder_length();
        int width = o.getOrder_width();
        int shedlength = o.getOrder_length_shed();
        int shedwidth = o.getOrder_width_shed();
         */
 /* request.setAttribute("length", logic.getOrder(id).getOrder_length());
        request.setAttribute("width", logic.getOrder(id).getOrder_width());
        request.setAttribute("shedlength",logic.getOrder(id).getOrder_length_shed());
        request.setAttribute("shedwidth", logic.getOrder(id).getOrder_width_shed());
         */
        
        request.setAttribute("id", id);
        return "Dimensions.jsp";
    }
}
