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
public class CommandPartlists extends Command {

    public CommandPartlists() {
    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        String shed = request.getParameter("shed");
        int shedlength = Integer.parseInt(request.getParameter("shedlength"));
        int shedwidth = Integer.parseInt(request.getParameter("shedlength"));
        
        
        request.setAttribute("length", length);
        request.setAttribute("width", width);
        request.setAttribute("shedlength", shedlength);
        request.setAttribute("shedwidth", shedwidth);
        if (shed.equals("false")) {
            Carport carport = logic.createSimpleCarport(length, width);
            CarportCalc CarportCalc = logic.createSimpleCarportCalc(length, width);
            request.setAttribute("carport", carport);
            request.setAttribute("CarportCalc", CarportCalc);
            return "Partlists.jsp";
        } else {
            Carport carport = logic.createSimpleCarportWithShed(length, width);
            CarportCalcShed CarportCalcShed = logic.createSimpleCarportCalcWithShed(length, width, shedlength, shedwidth);
            carport.setShedlength(shedlength);
            carport.setShedwidth(shedwidth);
            request.setAttribute("carport", carport);
            request.setAttribute("CarportCalcShed", CarportCalcShed);
            return "PartlistsShed.jsp";
        }


        
    }
}
