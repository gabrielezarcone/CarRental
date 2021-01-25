package com.gabrielez.CarRental;

import com.gabrielez.CarRental.dao.PrenotazioneDao;
import com.gabrielez.CarRental.dao.UserDao;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MostraPrenotazioni", value = "/MostraPrenotazioni")
public class MostraPrenotazioni extends HttpServlet {

    private List<Prenotazione> listaPrenotazioni;
    private User user;

    public static MostraPrenotazioni mostraPrenotazioniUtente(String username, List<Prenotazione> listaPrenotazioni) {
        MostraPrenotazioni mp = new MostraPrenotazioni();
        User user = UserDao.getUser(username);
        mp.setUser(user);
        mp.setListaPrenotazioni(listaPrenotazioni);
        return mp;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User loggedUser = (User) request.getSession().getAttribute("loggedUser");
        if (this.listaPrenotazioni==null){
            // se è diverso da null vol dire che contiene i risultati della ricerca
            this.listaPrenotazioni = PrenotazioneDao.listaPrenotazioniCustomer(this.user);
        }
        request.setAttribute("listaPrenotazioni",  this.listaPrenotazioni);
        request.setAttribute("selectedCustomer", this.user.getUsername());
        if(loggedUser!=null && loggedUser.isIs_admin()){
            request.setAttribute("pagina", "homeAdmin.jsp");
        }
        else {
            request.setAttribute("pagina", "homeCustomer.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public List<Prenotazione> getListaPrenotazioni() {
        return listaPrenotazioni;
    }

    public void setListaPrenotazioni(List<Prenotazione> listaPrenotazioni) {
        this.listaPrenotazioni = listaPrenotazioni;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
