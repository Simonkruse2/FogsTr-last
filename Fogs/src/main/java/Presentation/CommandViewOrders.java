package Presentation;

import Data.Carport;
import Logic.CarportCalc;
import Logic.CarportCalcShed;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class CommandViewOrders extends Command {

    public CommandViewOrders() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("id", id);
        int length = logic.getOrder(id).getOrder_length();
        int width = logic.getOrder(id).getOrder_width();
        int shedlength = logic.getOrder(id).getOrder_length_shed();
        int shedwidth = logic.getOrder(id).getOrder_width_shed();

        if (shedlength != 0 && shedwidth != 0) {
            Carport carport = logic.createSimpleCarportWithShed(length, width);
            CarportCalcShed CarportCalcShed = logic.createSimpleCarportCalcWithShed(length, width, shedlength, shedwidth);
            carport.setShedlength(shedlength);
            carport.setShedwidth(shedwidth);
            request.setAttribute("id", id);
            request.setAttribute(
                    "carport", carport);
            request.setAttribute(
                    "CarportCalcShed", CarportCalcShed);
            return "PartslistsShed.jsp";
        } else {
            Carport carport = logic.createSimpleCarport(length, width);
            CarportCalc CarportCalc = logic.createSimpleCarportCalc(length, width);
            request.setAttribute("id", id);
            request.setAttribute(
                    "carport", carport);
            request.setAttribute(
                    "CarportCalc", CarportCalc);
            return "Partslists.jsp";
        }
    }
}
