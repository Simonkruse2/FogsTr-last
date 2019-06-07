package Presentation;

import Data.UserException;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class CommandUpdatePrice extends Command {

    public CommandUpdatePrice() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, UserException {

        int id = (int) request.getSession().getAttribute("id");
        int newPrice = Integer.parseInt(request.getParameter("price"));
        logic.updatePrice(id, newPrice);
        return "ViewOrders.jsp";
    }

}
