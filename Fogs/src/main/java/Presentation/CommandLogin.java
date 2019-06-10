package Presentation;

import Data.UserException;
import Data.User;
import Data.UserMapper;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */
public class CommandLogin extends Command {

    HttpSession session;

    /**
     * Checks login. A session is created and attributes are set based on which
     * user/customer is trying to log in as. If the login is successful, the
     * user is forwarded to dimensions.jsp, if not, then index.jsp.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws Presentation.UserException
     */
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws
            IllegalArgumentException, ServletException, UserException, IOException {
        session = request.getSession();

        try {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserMapper um = new UserMapper();
            User u = um.getEmployee(username);

            session.setAttribute("user", u);
            boolean valid = um.checkLogin(username, password);

            if (valid && username != null && password != null && !("".equals(username))
                    && !("".equals(password))) {
                session.setAttribute("user", u);
                return "Dimensions.jsp";
            } else {
                throw new UserException("Wrong username or password");
            }
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Illegal imput");
        } catch (UserException ue) {
            session.setAttribute("loginerror", ue.getMessage());
            return "index.jsp";

        }

    }
}
