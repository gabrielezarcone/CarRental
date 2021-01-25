package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.AutoDao;
import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {

    private List<User> customerList;
    private List<Prenotazione> listaPrenotazioni;

    public Home(){
        UserDao userDao = new UserDao();
        this.customerList = userDao.getCustomers();
    }

    // Static factory method
    public static Home risultatiRicercaCustomer(List<User> customerList){
        Home home = new Home();
        home.setCustomerList(customerList);
        return home;
    }
    // Static factory method
    public static Home risultatiRicercaPrenotazioni(List<Prenotazione> listaPrenotazioni){
        Home home = new Home();
        home.setListaPrenotazioni(listaPrenotazioni);
        return home;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loggedUser");
        if(user!=null && user.isIs_admin()){
            // Se l'utente è admin viene indirizzato verso la lista dei customer
            session.setAttribute("customersList",this.customerList);
            request.setAttribute("pagina", "homeAdmin.jsp");
        }
        else if (user!=null){
            // se l'utente non è admin, prima di essere indirizzato alla lista delle prenotazioni, questa
            // deve essere prima generata dal servlet MostraPrenotazioni
            request.setAttribute("pagina", "MostraPrenotazioni?username="+user.getUsername());
            List<Auto> autoList = AutoDao.getAutoList();
            request.setAttribute("autoList", autoList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request,response);
    }



    public List<User> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<User> customerList) {
        this.customerList = customerList;
    }

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }
}
