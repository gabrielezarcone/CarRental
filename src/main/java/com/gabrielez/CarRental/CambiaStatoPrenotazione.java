package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.FileStore;

@WebServlet(name = "CambiaStatoPrenotazione", value = "/CambiaStatoPrenotazione")
public class CambiaStatoPrenotazione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        User loggedUser = (User) httpSession.getAttribute("loggedUser");
        if(loggedUser!=null && loggedUser.isIs_admin()){
            String stato = request.getParameter("stato");
            String id = request.getParameter("id");
            Prenotazione prenotazione = PrenotazioneDao.getPrenotazioneById(id);
            if (stato.equals("approva")) {
                PrenotazioneDao.approva(prenotazione);
            } else if (stato.equals("rifiuta")) {
                PrenotazioneDao.rifiuta(prenotazione);
            }
        }
    }
}
