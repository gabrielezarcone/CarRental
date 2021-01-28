package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;

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
        // Sia la procedura per modificare la prenotazione che quella per aggiungerne una nuova usano questo metodo
        String idPrenotazione = request.getParameter("id");
        Prenotazione prenotazione = new Prenotazione();
        if (idPrenotazione != null){
            // Se l'id non è settato prenotazione rimarra un oggetto nuovo
            // Se l'id invece è settato vuol dire che sto aggiornando una riga esistente e quindi recupero l'oggetto corrispondente e lo sostituisco
            prenotazione = PrenotazioneDao.getPrenotazioneById(idPrenotazione);
        }
        List<Auto> autoList = AutoDao.getAutoList();
        request.setAttribute("prenotazione", prenotazione);
        request.setAttribute("autoList", autoList);
        request.setAttribute("pagina", "updatePrenotazione.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loggedUser = (User) request.getSession().getAttribute("loggedUser");
        Prenotazione prenotazione = PrenotazioneDao.getPrenotazioneById(request.getParameter("id"));
        if(prenotazione == null){
            prenotazione = new Prenotazione();
            // solo se la prenotazione è nuova bisogna settare l'utente.
            prenotazione.setUser(loggedUser);
        }
        Auto auto = AutoDao.getAutoById(request.getParameter("auto"));
        prenotazione.setAuto(auto);
        // ogni volta che viene fatta una modifica alla prenotazione l'admin dovrà nuovamente approvarla
        prenotazione.setStato(Prenotazione.Stato.DA_APPROVARE);
        try {
            String inizio = request.getParameter("inizio");
            prenotazione.setInizio( new SimpleDateFormat("yyyy-MM-dd").parse(inizio));
            String fine = request.getParameter("fine");
            prenotazione.setFine( new SimpleDateFormat("yyyy-MM-dd").parse(fine));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PrenotazioneDao.updatePrenotazione(prenotazione);
        response.sendRedirect("home?reset=1");
    }
}
