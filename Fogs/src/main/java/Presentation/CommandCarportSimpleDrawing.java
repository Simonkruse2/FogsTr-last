/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Carport;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author simon
 */
public class CommandCarportSimpleDrawing extends Command {

    public CommandCarportSimpleDrawing() {
    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        Carport carport = logic.createSimpleCarport(length, width);
        request.setAttribute("carport", carport);
        return "CarportSimpleDrawing.jsp";
    }
}
