package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.entity.Auto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CercaAuto", value = "/CercaAuto")
public class CercaAuto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filtro = request.getParameter("filtro");
        String testo = request.getParameter("testoRicerca");
        List<Auto> autoList =  AutoDao.cerca(testo, filtro);
        ParcoAuto.renderSearchPage(autoList,request,response);
    }
}
