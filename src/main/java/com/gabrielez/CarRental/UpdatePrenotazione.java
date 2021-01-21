package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.Prenotazione;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UpdatePrenotazione", value = "/UpdatePrenotazione")
public class UpdatePrenotazione extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPrenotazione = request.getParameter("id");
        Prenotazione prenotazione = PrenotazioneDao.getPrenotazioneById(idPrenotazione);
        List<Auto> autoList = AutoDao.getAutoList();
        request.setAttribute("prenotazione", prenotazione);
        request.setAttribute("autoList", autoList);
        request.setAttribute("pagina", "updatePrenotazione.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prenotazione prenotazione = PrenotazioneDao.getPrenotazioneById(request.getParameter("id"));
        if(prenotazione == null){
            prenotazione = new Prenotazione();
        }
        Auto auto = AutoDao.getAutoById(request.getParameter("auto"));
        prenotazione.setAuto(auto);
        try {
            String inizio = request.getParameter("inizio");
            prenotazione.setInizio( new SimpleDateFormat("yyyy-MM-dd").parse(inizio));
            String fine = request.getParameter("fine");
            prenotazione.setFine( new SimpleDateFormat("yyyy-MM-dd").parse(fine));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PrenotazioneDao.updatePrenotazione(prenotazione);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
