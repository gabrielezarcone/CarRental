package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PrenotazioneDao {

    public static List<Prenotazione> listaPrenotazioniCustomer(User user){
        if(user!=null){
            try(Session session = HibernateUtil.getSessionFactory().openSession()){
                String query = "FROM Prenotazione WHERE user= :userID";
                Query<Prenotazione> q =  session.createQuery(query, Prenotazione.class);
                q.setParameter("userID", user);
                return q.list();
            }
        }
        else {
            return null;
        }
    }
}
