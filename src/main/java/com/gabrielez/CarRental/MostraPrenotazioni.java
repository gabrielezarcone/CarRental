package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MostraPrenotazioni", value = "/MostraPrenotazioni")
public class MostraPrenotazioni extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =  request.getParameter("username").toString();
        User loggedUser = (User) request.getSession().getAttribute("loggedUser");
        User user = UserDao.getUser(username);
        request.setAttribute("listaPrenotazioni",PrenotazioneDao.listaPrenotazioniCustomer(user));
        request.setAttribute("selectedCustomer", username);
        if(loggedUser!=null && loggedUser.isIs_admin()){
            request.setAttribute("pagina", "homeAdmin.jsp");
        }
        else {
            request.setAttribute("pagina", "homeCustomer.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
