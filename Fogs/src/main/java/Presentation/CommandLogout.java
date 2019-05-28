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
import javax.servlet.http.HttpSession;

/**
 *
 * @author simon
 */
public class CommandLogout extends Command {

    public CommandLogout() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, UserException, OrderException, DimensionsException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index.jsp";
    }

}
