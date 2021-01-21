package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
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

    private static void cambiaStato(Prenotazione prenotazione, Prenotazione.Stato stato){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            prenotazione.setStato(stato);
            session.saveOrUpdate(prenotazione);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public static void approva(Prenotazione prenotazione){
        cambiaStato(prenotazione, Prenotazione.Stato.APPROVATO);
    }
    public static void rifiuta(Prenotazione prenotazione){
        cambiaStato(prenotazione, Prenotazione.Stato.RIFIUTATO);
    }

    public static Prenotazione getPrenotazioneById(String id) {
        Long longID = Long.parseLong(id, 10);
        return getPrenotazioneById(longID);
    }

    public static Prenotazione getPrenotazioneById(Long id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(Prenotazione.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
