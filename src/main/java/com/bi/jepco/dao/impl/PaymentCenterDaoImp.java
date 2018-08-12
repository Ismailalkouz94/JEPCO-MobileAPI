package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.MobileTipsDao;
import com.bi.jepco.dao.PaymentCenterDao;
import com.bi.jepco.entities.MobileTips;
import com.bi.jepco.entities.PaymentCenter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PaymentCenterDaoImp implements PaymentCenterDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public List<PaymentCenter> find() {
      return sessionFactory.getCurrentSession().createQuery("from PaymentCenter").list();
   }
}
