/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Carport;
import Logic.CarportCalc;
import Logic.CarportCalcShed;
import Logic.LogicFacade;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renz
 */
public class CommandPartslists extends Command {

    public CommandPartslists() {
    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, DimensionsException {
        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        String shed = request.getParameter("shed");
        int shedlength = Integer.parseInt(request.getParameter("shedlength"));
        int shedwidth = Integer.parseInt(request.getParameter("shedwidth"));

        try {
            request.setAttribute("length", length);
            request.setAttribute("width", width);
            request.setAttribute("shedlength", shedlength);
            request.setAttribute("shedwidth", shedwidth);
            if (shed.equals("false")) {
                Carport carport = logic.createSimpleCarport(length, width);
                CarportCalc CarportCalc = logic.createSimpleCarportCalc(length, width);
                request.setAttribute("carport", carport);
                session.setAttribute("carport", carport);
                request.setAttribute("CarportCalc", CarportCalc);
                session.setAttribute("CarportCalc", CarportCalc);
                return "Partslists.jsp";
            } else {
                if (length < shedlength || width < shedwidth) {
                    throw new DimensionsException("Shed dimensions can't be bigger than the carport");
                }
                Carport carport = logic.createSimpleCarportWithShed(length, width);
                CarportCalcShed CarportCalcShed = logic.createSimpleCarportCalcWithShed(length, width, shedlength, shedwidth);
                carport.setShedlength(shedlength);
                carport.setShedwidth(shedwidth);
                request.setAttribute("carport", carport);
                session.setAttribute("carport", carport);
                request.setAttribute("CarportCalcShed", CarportCalcShed);
                session.setAttribute("CarportCalcShed", CarportCalcShed);
                return "PartslistsShed.jsp";
            }
        } catch (DimensionsException de) {
            session.setAttribute("error", de.getMessage());
            return "Dimensions.jsp";
        }

    }
}
