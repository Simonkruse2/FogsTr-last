package Presentation;

import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CommandUpdateStatus extends Command {

    public CommandUpdateStatus() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, UserException, OrderException {
        int id = (int) request.getSession().getAttribute("id");
        String newStatus = request.getParameter("newStatus");
        logic.updateStatus(id, newStatus);
        return "ViewOrders.jsp";
    }
}
