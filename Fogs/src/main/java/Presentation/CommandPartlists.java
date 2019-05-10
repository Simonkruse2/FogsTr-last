/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Carport;
import Logic.CarportCalc;
import Logic.CarportCalcShed;
import Logic.LogicFacade;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Renz
 */
public class CommandPartlists extends Command{
    
    public CommandPartlists(){
    }
    
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException{
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        Carport carport = logic.createSimpleCarportWithShed(length, width);
        CarportCalc CarportCalc = logic.createSimpleCarportCalc(length, width);
        request.setAttribute("carport", carport);
        request.setAttribute("CarportCalc", CarportCalc);
        return "Partlists.jsp";
    }
}
