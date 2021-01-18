package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserInfo", value = "/updateUserInfo")
public class UpdateUserInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = UserDao.getUser(username);
        request.setAttribute("userInfo", user);
        request.setAttribute("pagina", "updateUserInfo.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDao.getUser(request.getParameter("username"));
        user.setUsername(request.getParameter("username"));
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        try {
            String date = request.getParameter("birth_date");
            if(date != null){
                user.setBirth_date( new SimpleDateFormat("yyyy-MM-dd").parse(date));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String password = request.getParameter("password");
        if(!password.equals("")){
            user.setPassword(request.getParameter("password"));
        }
        UserDao.updateUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
}