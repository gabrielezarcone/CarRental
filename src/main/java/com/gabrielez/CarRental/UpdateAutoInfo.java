package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAutoInfo", value = "/UpdateAutoInfo")
public class UpdateAutoInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Controllo che l'utente loggato sia un admin prima di farlo accedere alla pagina di modifica
        HttpSession httpSession = request.getSession();
        User loggedUser = (User) httpSession.getAttribute("loggedUser");
        if(loggedUser!=null && loggedUser.isIs_admin()){
            Auto auto = AutoDao.getAutoById(request.getParameter("id"));
            request.setAttribute("autoInfo", auto);
            request.setAttribute("pagina", "updateAutoInfo.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Auto auto = AutoDao.getAutoById(request.getParameter("id"));
        if(auto==null){
            auto = new Auto();
        }
        AutoDao.addAuto(auto, request);
        request.setAttribute("pagina", "parcoAuto.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}
