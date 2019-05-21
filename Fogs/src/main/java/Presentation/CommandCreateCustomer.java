/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author simon
 */
public class CommandCreateCustomer extends Command {

    public CommandCreateCustomer() {
    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        User u = null;
        u.setName(request.getParameter("name"));
        u.setPhone(request.getParameter("phone"));
        u.setUsername(request.getParameter("email"));
        logic.createCustomer(u);
        return "index.jsp";
    }
}
