package Presentation;

import Data.Carport;
import Data.Order;
import Data.User;
import Logic.CarportCalcShed;
import Logic.LogicFacade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jacob, Renz, Vincent og Simon.
 */

public class CommandCreateOrderShed extends Command {

    public CommandCreateOrderShed() {

    }

    @Override
    public String execute(HttpServletRequest request, LogicFacade logic) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {

            User u = (User) session.getAttribute("user");
            Carport carport = (Carport) session.getAttribute("carport");
            CarportCalcShed calcShed = (CarportCalcShed) session.getAttribute("CarportCalcShed");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

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
            User customer = new User(name, email);
            customer.setPhone(phone);
            logic.createCustomer(customer);
            customer.setId(logic.getCustomer(customer.getUsername()).getId());
            Order o = new Order("In progress", carport.getWidthOuter(), carport.getLengthOuter(), 0,
                    customer.getId(), u.getId(), calcShed.getPrice());
            o.setOrder_width_shed(carport.getShedwidth());
            o.setOrder_length_shed(carport.getShedlength());
            logic.createOrderShed(o);
        } catch (OrderException oe) {
            session.setAttribute("error", oe.getMessage());
            return "Dimensions.jsp";
        }
        return "ViewOrders.jsp";
    }

}
