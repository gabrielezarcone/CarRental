package com.gabrielez.CarRental;

import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewCustomer", value = "/NewCustomer")
public class NewCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Controllo che l'utente loggato sia un admin prima di farlo accedere alla pagina di modifica
        HttpSession httpSession = request.getSession();
        User loggedUser = (User) httpSession.getAttribute("loggedUser");
        if(loggedUser!=null && loggedUser.isIs_admin()){
            String username = request.getParameter("username");
            User user = new User();
            request.setAttribute("userInfo", user);
            request.setAttribute("pagina", "updateUserInfo.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
