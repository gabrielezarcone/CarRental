package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.util.DateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "DeletePrenotazione", value = "/DeletePrenotazione")
public class DeletePrenotazione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prenotazione prenotazione = PrenotazioneDao.getPrenotazioneById(request.getParameter("id"));
        Date oggi = new Date();
        Date dataPrenotazione = prenotazione.getInizio();
        Long i = DateUtil.diffGiorni(oggi, dataPrenotazione);
        boolean a =  oggi.before(dataPrenotazione);
        if (!DateUtil.diffMenoNGiorni(oggi, dataPrenotazione,2) && oggi.before(dataPrenotazione)) {
            PrenotazioneDao.delete(prenotazione);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
