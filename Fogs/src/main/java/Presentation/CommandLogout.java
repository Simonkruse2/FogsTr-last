package Presentation;

import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandLogout extends Command {

    public CommandLogout() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, UserException, OrderException, DimensionsException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index.jsp";
    }

}
