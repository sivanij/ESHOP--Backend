package com.upgrad.capstone.dao;

import com.upgrad.capstone.entities.eshopOrder;
import com.upgrad.capstone.entities.eshopShippingAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
@Repository
public class eshopShippingAddressDAOImpl implements eshopShippingAddressDAO{
    private SessionFactory sessionFactory;
    @Autowired
    public eshopShippingAddressDAOImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public eshopShippingAddress save(eshopShippingAddress shoppingList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(shoppingList);
        transaction.commit();
        session.close();
        return shoppingList;
    }

    @Override
    public eshopShippingAddress findById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopShippingAddress items = session.get(eshopShippingAddress.class,id);
        transaction.commit();
        session.close();
        return items;
    }

    @Override
    public void delete(eshopShippingAddress shippingAddressList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        eshopShippingAddress mergedList = (eshopShippingAddress)session.merge(shippingAddressList);
        session.delete(mergedList);

        transaction.commit();
        session.close();
    }
}
