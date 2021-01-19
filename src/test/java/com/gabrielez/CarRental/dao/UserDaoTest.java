package com.gabrielez.CarRental.dao;

import com.gabrielez.CarRental.entity.User;
import com.gabrielez.CarRental.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private static User user = new User();
    private static Date date;

    @BeforeAll
    static void beforeAll() {
        date = new Date();
        user.setName("NomeProva");
        user.setSurname("CognomeProva");
        user.setPassword("PasswordProva");
        user.setBirth_date(date);
        user.setUsername("UsernameProva");
    }

    @AfterAll
    static void afterAll() {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.remove(user);
            transaction.commit();
        }
    }

    @Test
    void addUser() {
        UserDao userDao = new UserDao();
        userDao.addUser(user);
        User user1 = UserDao.getUser(user.getUsername());
        assertEquals("NomeProva",user1.getName());
        assertEquals("CognomeProva",user1.getSurname());
        assertEquals("PasswordProva",user1.getPassword());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        assertEquals(sdf.format(date),sdf.format(user1.getBirth_date()));
        assertEquals("UsernameProva",user1.getUsername());
    }

    @Test
    void getUsers() {
    }

    @Test
    void getCustomers() {
    }

    @Test
    void getAdmins() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void updateUser() {
    }
}