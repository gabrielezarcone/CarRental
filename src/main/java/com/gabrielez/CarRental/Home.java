package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isAdmin = (Boolean) request.getSession().getAttribute("isAdmin");
        if(isAdmin){
            UserDao userDao = new UserDao();
            request.setAttribute("customersList",userDao.getCustomers());
            request.setAttribute("pagina", "homeAdmin.jsp");
        }
        else{
            request.setAttribute("pagina", "homeCustomer.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }
}
