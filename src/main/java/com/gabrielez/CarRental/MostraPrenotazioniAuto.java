package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.Prenotazione;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MostraPrenotazioniAuto", value = "/MostraPrenotazioniAuto")
public class MostraPrenotazioniAuto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auto auto = AutoDao.getAutoById(request.getParameter("auto"));
        List<Prenotazione> listaPrenotazioni = PrenotazioneDao.listPrenotazioni(auto);
        List<Auto> autoList = AutoDao.getAutoList();
        request.setAttribute("autoList", autoList);
        request.setAttribute("selectedAuto", auto);
        request.setAttribute("listaPrenotazioni", listaPrenotazioni);
        request.setAttribute("pagina", "parcoAuto.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
