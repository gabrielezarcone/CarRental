package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =  request.getParameter("username").toString();
        String password =  request.getParameter("password").toString();
        User user = UserDao.getUser(username);
        try {
            if(user.getPassword().equals(password) && user.getUsername().equals(username)){
                // Imposto il nome utente in sessione
                HttpSession session = request.getSession();
                session.setAttribute("loggedUser", user);
            }
            else {
                request.setAttribute("loginErrato", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("loginErrato", true);
        }
        Home home = new Home();
        home.doGet(request, response);
    }
}
