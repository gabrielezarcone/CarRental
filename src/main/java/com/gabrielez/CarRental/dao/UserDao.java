package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.Auto;
import com.gabrielez.CarRental.entity.User;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class UserDao {

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
            User user = session.load(User.class,username);
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
            Query query = session.createQuery(queryStr);
            query.setParameter("username", username);
            return (User) query.getSingleResult();
        }
    }

    public static void updateUser(User user){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(user);
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
