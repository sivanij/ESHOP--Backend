package com.upgrad.capstone.dao;


import com.upgrad.capstone.entities.eshopUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;
@Repository
public class eshopUserDAOImpl implements eshopUserDAO{

    private SessionFactory sessionFactory;
@Autowired
    public  eshopUserDAOImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public List<eshopUser> findByFirstName(String firstName) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopUser user = session.get(eshopUser.class,firstName);
        transaction.commit();
        session.close();
        return (List<eshopUser>) user;
    }

    @Override
    public List<eshopUser> findByLastName(String lastName) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopUser user = session.get(eshopUser.class,lastName);
        transaction.commit();
        session.close();
        return (List<eshopUser>) user;
    }

    @Override
    public List<eshopUser> findByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopUser user = session.get(eshopUser.class,email);
        transaction.commit();
        session.close();
        return (List<eshopUser>) user;
    }

    @Override
    public List<eshopUser> findByMobileNumber(String mobileNumber) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopUser user = session.get(eshopUser.class,mobileNumber);
        transaction.commit();
        session.close();
        return (List<eshopUser>) user;

    }

    @Override
    public eshopUser save(eshopUser usersList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(usersList);
        transaction.commit();
        session.close();
        return usersList;
    }

    @Override
    public eshopUser findById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
         eshopUser user = session.get(eshopUser.class,id);
         transaction.commit();
         session.close();
        return user;
    }

    @Override
    public void delete(eshopUser usersList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        eshopUser mergedCustomer = (eshopUser)session.merge(usersList);
        session.delete(mergedCustomer);

        transaction.commit();
        session.close();
    }
}
