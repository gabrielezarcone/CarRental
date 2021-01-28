package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.entity.Auto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParcoAuto", value = "/ParcoAuto")
public class ParcoAuto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("autoList", AutoDao.getAutoList());
        request.setAttribute("pagina", "parcoAuto.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected static void renderSearchPage(List<Auto> autoList, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("autoList", autoList);
        request.setAttribute("pagina", "parcoAuto.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
