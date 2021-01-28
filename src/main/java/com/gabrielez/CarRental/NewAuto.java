package com.gabrielez.CarRental;

import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewAuto", value = "/NewAuto")
public class NewAuto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Controllo che l'utente loggato sia un admin
        HttpSession httpSession = request.getSession();
        User loggedUser = (User) httpSession.getAttribute("loggedUser");
        if(loggedUser!=null && loggedUser.isIs_admin()){
            Auto auto = new Auto();
            request.setAttribute("autoInfo", auto);
            request.setAttribute("pagina", "updateAutoInfo.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
