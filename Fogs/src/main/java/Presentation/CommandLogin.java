/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.User;
import Data.UserMapper;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author simon
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
     */
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws IllegalArgumentException, ServletException, IOException {
        session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserMapper um = new UserMapper();
        User u = um.getEmployee(username);

        session.setAttribute("user", u);
        boolean valid = um.checkLogin(username, password);

        if (valid && username != null && password != null && !("".equals(username))
                && !("".equals(password))) {
            System.out.println("User exists");
            session.setAttribute("user", u);
            return "Dimensions.jsp";
        } else {
            System.out.println("user doesnt exist");
            System.out.println(password);
            System.out.println(username);
            session.invalidate();
            return "index.jsp";
        }
    }

}
