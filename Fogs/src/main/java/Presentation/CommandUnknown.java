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
public class CommandUnknown extends Command {

    public CommandUnknown() {
    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        request.setAttribute("error", "unknown command");
        return "index.jsp";
    }
}
