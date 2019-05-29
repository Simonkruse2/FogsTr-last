package Presentation;

import Data.Carport;
import Logic.CarportCalc;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CommandCarportSimpleDrawing extends Command {

    public CommandCarportSimpleDrawing() {
    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        Carport carport = logic.createSimpleCarport(length, width);
        CarportCalc CarportCalc = logic.createSimpleCarportCalc(length, width);
        request.setAttribute("carport", carport);
        request.setAttribute("CarportCalc", CarportCalc);
        return "CarportSimpleDrawing.jsp";
    }
}
