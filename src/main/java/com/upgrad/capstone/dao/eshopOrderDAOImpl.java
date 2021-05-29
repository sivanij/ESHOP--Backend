package com.upgrad.capstone.dao;

import com.upgrad.capstone.entities.eshopOrder;
import com.upgrad.capstone.entities.eshopProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
@Repository
public class eshopOrderDAOImpl implements eshopOrderDAO{
    private SessionFactory sessionFactory;
    @Autowired
    public eshopOrderDAOImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public eshopOrder save(eshopOrder orderList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orderList);
        transaction.commit();
        session.close();
        return orderList;
    }

    @Override
    public eshopOrder findById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopOrder order = session.get(eshopOrder.class,id);
        transaction.commit();
        session.close();
        return order;
    }

    @Override
    public void delete(eshopOrder orderList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        eshopOrder mergedOrder = (eshopOrder)session.merge(orderList);
        session.delete(mergedOrder);

        transaction.commit();
        session.close();

    }
}
