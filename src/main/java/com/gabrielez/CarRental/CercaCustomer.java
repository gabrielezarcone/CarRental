package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CercaCustomer", value = "/CercaCustomer")
public class CercaCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filtro = request.getParameter("filtro"); //Corrisponde alla campo da ricercare scelto da utente
        String testo = request.getParameter("testo"); //Corrisponde al testo inserito da utente
        List<User> risultati =  UserDao.cercaCustomers(testo, filtro);
        Home home = new Home(risultati);
        home.doGet(request, response);
    }
}
