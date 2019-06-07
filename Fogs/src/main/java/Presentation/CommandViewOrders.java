package Presentation;

import Data.Carport;
import Data.OrderException;
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
        int length;
        int width;
        int shedlength;
        int shedwidth;
        int id;
        try {
            if("".equals(request.getParameter("id"))){
                throw new OrderException("ID must be filled out");
            }
            if (Integer.parseInt(request.getParameter("id")) == 0) {
                throw new OrderException("ID cant be zero");
            }else{
                id = Integer.parseInt(request.getParameter("id"));
            }
            if (logic.getOrder(id) == null) {
                throw new OrderException("Order ID doesn't exist");
            } else {
                session.setAttribute("id", id);
                length = logic.getOrder(id).getOrder_length();
                width = logic.getOrder(id).getOrder_width();
                shedlength = logic.getOrder(id).getOrder_length_shed();
                shedwidth = logic.getOrder(id).getOrder_width_shed();
            }

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
        } catch (OrderException oe) {
            session.setAttribute("Error", oe.getMessage());
            return "ViewOrders.jsp";
        }
    }
}
