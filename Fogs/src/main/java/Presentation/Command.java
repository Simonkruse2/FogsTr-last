package Presentation;

import Logic.LogicFacade;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author simon
 */
public abstract class Command {

    private final static Command UNKNOWN = new CommandUnknown();
    private static Map<String, Command> commands;

    public abstract String execute(
            HttpServletRequest request,
            LogicFacade logic)
            throws ServletException, IOException;

    public static Command from(HttpServletRequest request) {
        if (commands == null) {
            commands = new HashMap();
            commands.put("CarportSimpleDrawing", new CommandCarportSimpleDrawing());
            commands.put("Partlists", new CommandPartlists());
            // commands.put("login", new CommandLogin());
        }
        String origin = request.getParameter("command");

        return commands.getOrDefault(origin, UNKNOWN);
    }
}
