/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author simon
 */
public class CommandUpdatePrice extends Command {

    public CommandUpdatePrice() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, UserException {

        int id = (int) request.getSession().getAttribute("id");
        int newPrice = Integer.parseInt(request.getParameter("price"));

        logic.updatePrice(id, newPrice);
        return "ViewOrders.jsp";
    }

}
