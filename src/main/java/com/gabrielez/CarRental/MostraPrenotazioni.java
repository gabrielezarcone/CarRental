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
        User user = UserDao.getUser(username);
        request.setAttribute("listaPrenotazioni",PrenotazioneDao.listaPrenotazioniCustomer(user));
        request.setAttribute("selectedCustomer", username);
        request.setAttribute("pagina", "homeAdmin.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
