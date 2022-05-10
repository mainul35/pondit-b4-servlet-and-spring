package com.pondit.b4.dao;

import com.pondit.b4.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void createUser() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        var session = sessionFactory.getCurrentSession();
        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
