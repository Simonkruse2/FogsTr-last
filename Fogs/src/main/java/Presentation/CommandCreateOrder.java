package Presentation;

import Data.Carport;
import Data.Order;
import Data.User;
import Logic.CarportCalc;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class CommandCreateOrder extends Command {

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException, OrderException {
        HttpSession session = request.getSession();

        try {
            User u = (User) session.getAttribute("user");
            Carport carport = (Carport) session.getAttribute("carport");
            CarportCalc calc = (CarportCalc) session.getAttribute("CarportCalc");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            User customer = new User(name, email);
            if ("".equals(name) || name == null) {
                throw new OrderException("Name must be filled out");
            }
            if ("".equals(phone) || phone == null) {
                throw new OrderException("Phonenumber must be filled out");
            }
            if (!phone.matches(".*\\d.*")) {
                throw new OrderException("Phone can't contain letters or signs");
            }
            if ("".equals(email) || email == null) {
                throw new OrderException("E-mail must be filled out");
            }
            if (!(email.contains("@")) && !(email.contains("."))) {
                throw new OrderException("Incorrect e-mail");
            }
            customer.setPhone(phone);
            logic.createCustomer(customer);
            customer.setId(logic.getCustomer(customer.getUsername()).getId());
            Order o = new Order("In progress", carport.getWidthOuter(), carport.getLengthOuter(), 0,
                    customer.getId(), u.getId(), calc.getPrice());
            logic.createOrder(o);
        } catch (OrderException oe) {
            session.setAttribute("error", oe.getMessage());
            return "Dimensions.jsp";
        }
        return "ViewOrders.jsp";
    }

}
