package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.entity.Prenotazione;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePrenotazione", value = "/UpdatePrenotazione")
public class UpdatePrenotazione extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idPrenotazione = request.getParameter("id");
        Prenotazione prenotazione = PrenotazioneDao.getPrenotazioneById(idPrenotazione);
        request.setAttribute("prenotazione", prenotazione);
        request.setAttribute("pagina", "updatePrenotazione.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
