package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AutoDao {

    public static void addAuto(Auto auto, HttpServletRequest request) {
        try {
            auto.setCostruttore(request.getParameter("costruttore"));
            auto.setModello(request.getParameter("modello"));
            auto.setTarga(request.getParameter("targa"));
            auto.setTipologia(request.getParameter("tipologia"));
            String immatricolazioneStr = request.getParameter("immatricolazione");
            auto.setImmatricolazione(new SimpleDateFormat("yyyy-MM-dd").parse(immatricolazioneStr));
            saveAuto(auto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserisce una nuova auto nel parco auto
     * @param auto  Auto da inserire
     */
    public static void saveAuto(Auto auto){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // Inizia transizione
            transaction  = session.beginTransaction();
            // Salva l'oggetto auto
            session.saveOrUpdate(auto);
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
    public static List<Auto> getAutoList(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Auto", Auto.class).list();
        }
    }

    public static Auto getAutoById(String id){
        try {
            Long longID = Long.parseLong(id, 10);
            return getAutoById(longID);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null; //nel caso in cui l'ID passato non sia valido
        }
    }

    public static Auto getAutoById(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Auto.class, id);
        }
    }

}
