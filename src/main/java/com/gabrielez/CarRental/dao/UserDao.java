package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.User;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    public static List<User> cercaCustomers(String testo, String chiaveRicerca) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            // Uso criteria per rendere dinamica la colonna su cui fare il Like
            CriteriaBuilder builder = session.getCriteriaBuilder();
            // Definisco lo scheletro della query indicando che il risultato della stessa sarà un oggetto User
            CriteriaQuery<User> query = builder.createQuery(User.class);
            // FROM User as u
            Root<User> u = query.from(User.class);
            // SELECT * FROM u
            query.select(u);
            // SELECT * FROM u WHERE chiaveRicerca LIKE :testoParam and is_admin=false
            ParameterExpression<String> testoParam = builder.parameter(String.class); //definisco un parametro per evitare sql injection
            query.where(
                    builder.like(u.get(chiaveRicerca),testoParam),
                    builder.equal(u.get("is_admin"), false)
            );
            //ottengo i risultati
            return session.createQuery(query)
                    .setParameter(testoParam, "%"+testo+"%") // :testoParam -> "%testo%"
                    .getResultList();
        }
    }

    public void addUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getUsers(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String query = "FROM User";
            return session.createQuery(query,User.class).list();
        }
    }

    public List<User> getCustomers(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String query = "FROM User WHERE is_admin=false";
            return session.createQuery(query,User.class).list();
        }}

    public List<User> getAdmins(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String query = "FROM User WHERE is_admin=true";
            return session.createQuery(query,User.class).list();
        }}

    public void deleteUser(String username) {
        Transaction transaction = null;
        try(Session session =HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = UserDao.getUser(username);
            user.setDeleted(true);
            session.update(user);
            transaction.commit();
        }
        catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static User getUser(String username){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String queryStr = "FROM User WHERE username=:username";
            return (User) session.createQuery(queryStr)
                .setParameter("username", username)
                .getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void updateUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
