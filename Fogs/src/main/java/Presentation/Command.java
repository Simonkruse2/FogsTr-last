package Presentation;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author simon
 */
public abstract class Command {

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request) {
        Command c;
        String origin = request.getParameter("command");
        HashMap<String, Command> commands;
        commands = new HashMap<>();
        commands.put("login.jsp", new CommandLogin());
        c = commands.getOrDefault(origin, new CommandUnknown());

        return c;
    }
}
