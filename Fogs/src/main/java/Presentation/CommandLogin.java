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
     * user is forwarded to shop.jsp, if not, then index.jsp.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {

        session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserMapper um = new UserMapper();
        User u = new User(um.getCustomer(email).getName(), um.getCustomer(email).getPhone(),
                um.getCustomer(email).getEmail());

        session.setAttribute("user", u);
        boolean valid = um.checkLogin(email, password);

        if (valid && email != null && password != null && !("".equals(email))
                && !("".equals(password))) {
            System.out.println("User exists");
            session.setAttribute("user", u);
            System.out.println(u.toString());
            return "Dimensions.jsp";
        } else {
            System.out.println("user doesnt exist");
            System.out.println(password);
            System.out.println(email);
            session.invalidate();
            return "index.jsp";
        }
    }

}
