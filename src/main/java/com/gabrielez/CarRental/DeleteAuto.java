package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.entity.Auto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteAuto", value = "/DeleteAuto")
public class DeleteAuto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auto auto = AutoDao.getAutoById(request.getParameter("id"));
        AutoDao.delete(auto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
