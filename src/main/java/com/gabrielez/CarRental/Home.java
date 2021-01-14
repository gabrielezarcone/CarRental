package com.gabrielez.CarRental;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        boolean isAdmin = (Boolean) request.getSession(false).getAttribute("isAdmin");
        if(isAdmin){
            request.setAttribute("pagina", "homeAdmin.jsp");
        }
        else{
            request.setAttribute("pagina", "homeCustomer.jsp");
        }
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
