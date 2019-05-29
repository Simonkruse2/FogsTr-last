package Presentation;

import Logic.LogicFacade;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public abstract class Command {

    private final static Command UNKNOWN = new CommandUnknown();
    private static Map<String, Command> commands;

    public abstract String execute(
            HttpServletRequest request,
            LogicFacade logic)
            throws ServletException, IOException, UserException, OrderException, DimensionsException;

    public static Command from(HttpServletRequest request) {
        if (commands == null) {
            commands = new HashMap();
            commands.put("CarportSimpleDrawing", new CommandCarportSimpleDrawing());
            commands.put("Login", new CommandLogin());
            commands.put("Partslists", new CommandPartslists());
            commands.put("CreateOrder", new CommandCreateOrder());
            commands.put("CreateOrderShed", new CommandCreateOrderShed());
            commands.put("ViewOrders", new CommandViewOrders());
            commands.put("UpdatePrice", new CommandUpdatePrice());
            commands.put("UpdateStatus", new CommandUpdateStatus());
            commands.put("Logout", new CommandLogout());
            commands.put("Unknown", new CommandUnknown());
        }
        String origin = request.getParameter("command");

        return commands.getOrDefault(origin, UNKNOWN);
    }
}
