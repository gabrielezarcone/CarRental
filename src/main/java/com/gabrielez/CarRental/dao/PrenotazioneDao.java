package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.Prenotazione;
import com.gabrielez.CarRental.entity.User;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        try {
            Long longID = Long.parseLong(id, 10);
            return getPrenotazioneById(longID);
        }
        catch (NumberFormatException nfe){
            // Se la striga non è numero o è null il metodo restituisce null
            nfe.printStackTrace();
            return null;
        }
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

    public static void updatePrenotazione(Prenotazione prenotazione){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(prenotazione);
            transaction.commit();
        }
        catch (Exception e){
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void delete(Prenotazione prenotazione){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.remove(prenotazione);
            transaction.commit();
        }
        catch(Exception e){
            if (transaction!= null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Prenotazione> cercaPrenotazioni(String testo, String chiaveRicerca, User loggedUser){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String query = "";
            switch (chiaveRicerca){
                case "auto":
                    Auto auto = AutoDao.getAutoById(testo);
                    query = "FROM Prenotazione where auto=:auto and user=:user";
                    return session.createQuery(query,Prenotazione.class)
                            .setParameter("auto", auto)
                            .setParameter("user", loggedUser)
                            .list();
                case "inizio":
                    query = "FROM Prenotazione where inizio=:testo and user=:user";
                    return session.createQuery(query,Prenotazione.class)
                            .setParameter("testo", new SimpleDateFormat("yyyy-MM-dd").parse(testo))
                            .setParameter("user", loggedUser)
                            .list();
                case "fine":
                    query = "FROM Prenotazione where fine=:testo and user=:user";
                    return session.createQuery(query,Prenotazione.class)
                            .setParameter("testo",  new SimpleDateFormat("yyyy-MM-dd").parse(testo))
                            .setParameter("user", loggedUser)
                            .list();
                case "stato":
                    query = "FROM Prenotazione where stato=:testo and user=:user";
                    return session.createQuery(query,Prenotazione.class)
                            .setParameter("testo", Prenotazione.Stato.valueOf(testo))
                            .setParameter("user", loggedUser)
                            .list();
            }
            return null;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Prenotazione> listPrenotazioni(Auto auto) {
        try(Session session=HibernateUtil.getSessionFactory().openSession()) {
            String queryStr = "from Prenotazione where auto=:auto";
            return session.createQuery(queryStr, Prenotazione.class)
                    .setParameter("auto", auto)
                    .list();
        }
    }
}
