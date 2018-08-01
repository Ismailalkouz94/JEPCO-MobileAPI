package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.SmsVerificationDao;
import com.bi.jepco.entities.SmsVerification;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SmsVerificationDaoImp implements SmsVerificationDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public SmsVerification create(SmsVerification smsVerification) {
      sessionFactory.getCurrentSession().save(smsVerification);
      return smsVerification;
   }

   @Override
   public SmsVerification find(String mobileNumber, Integer status) {
      return (SmsVerification) sessionFactory.getCurrentSession().createQuery("from SmsVerification" +
              " where mobileNumber = :mobileNumber" +
              " and status = :status")
              .setParameter("mobileNumber",mobileNumber)
              .setParameter("status",status)
              .uniqueResult();
   }

   @Override
   public SmsVerification update(SmsVerification smsVerification) {
      sessionFactory.getCurrentSession().update(smsVerification);
      return smsVerification;
   }
}
