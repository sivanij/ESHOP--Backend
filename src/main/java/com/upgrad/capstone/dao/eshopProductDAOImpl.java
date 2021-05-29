package com.upgrad.capstone.dao;


import com.upgrad.capstone.entities.eshopProduct;
import com.upgrad.capstone.entities.eshopUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
@Repository
public class eshopProductDAOImpl implements eshopProductDAO{
    private SessionFactory sessionFactory;
    @Autowired
    public  eshopProductDAOImpl(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }
    @Override
    public eshopProduct save(eshopProduct productList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(productList);
        transaction.commit();
        session.close();
        return productList;
    }

    @Override
    public eshopProduct findById(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        eshopProduct product = session.get(eshopProduct.class,id);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public void delete(eshopProduct productList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        eshopProduct mergedProduct = (eshopProduct)session.merge(productList);
        session.delete(mergedProduct);

        transaction.commit();
        session.close();
    }
}
