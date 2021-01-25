package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CercaPrenotazione", value = "/CercaPrenotazione")
public class CercaPrenotazione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loggedUser = (User) request.getSession().getAttribute("loggedUser");
        String filtro = request.getParameter("filtro");
        String testo = request.getParameter("testoRicerca");
        List<Prenotazione> risultati =  PrenotazioneDao.cercaPrenotazioni(testo, filtro, loggedUser);
        Home home = Home.risultatiRicercaPrenotazioni(risultati);
        home.doGet(request, response);
    }
}
