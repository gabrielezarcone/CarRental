package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AutoDao {

    /**
     * Inserisce una nuova auto nel parco auto
     * @param auto  Auto da inserire
     */
    public void saveAuto(Auto auto){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // Inizia transizione
            transaction  = session.beginTransaction();
            // Salva l'oggetto auto
            session.save(auto);
            // Commit della transizione
            transaction.commit();
        }
        catch (Exception e){
            if(transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Restituisce la lista delle auto del parco auto
     *
     * @return Lista di tutte le auto
     */
    public List<Auto> getAutos(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Auto", Auto.class).list();
        }
    }


}
