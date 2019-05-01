package Presentation;

import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class CommandUnknown extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        request.setAttribute("error", "unknown command");
        return "index.jsp";
    }

}
