package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.CustomerSubAccountDao;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerSubAccountDaoImp implements CustomerSubAccountDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public CustomerSubAccount create(CustomerSubAccount customerSubAccount) {
      sessionFactory.getCurrentSession().save(customerSubAccount);
      return customerSubAccount;
   }

   @Override
   public List<CustomerSubAccount> find(CustomerProfile customerProfile) {
      return sessionFactory.getCurrentSession().createQuery("from CustomerSubAccount cusSub" +
              " where cusSub.customerSubInfoPK.customerProfile = :customerProfile")
              .setParameter("customerProfile",customerProfile)
              .list();
   }


   @Override
   public CustomerSubAccount find(CustomerProfile customerProfile,String fileNumber) {
      return (CustomerSubAccount) sessionFactory.getCurrentSession().createQuery("from CustomerSubAccount cusSub" +
              " where cusSub.fileNumber = :fileNumber" +
              " and cusSub.customerSubInfoPK.customerProfile = :customerProfile")
              .setParameter("fileNumber",fileNumber)
              .setParameter("customerProfile",customerProfile)
              .uniqueResult();
   }

   @Override
   public List<CustomerSubAccount> find(String fileNumber) {
      return sessionFactory.getCurrentSession().createQuery("from CustomerSubAccount cusSub" +
              " where cusSub.fileNumber = :fileNumber")
              .setParameter("fileNumber",fileNumber)
              .list();
   }

   @Override
   public CustomerSubAccount update(CustomerSubAccount customerSubAccount) {
       sessionFactory.getCurrentSession().update(customerSubAccount);
       return customerSubAccount;
   }

   @Override
   public void delete(CustomerSubAccount customerSubAccount) {
      try{
         sessionFactory.getCurrentSession().delete(customerSubAccount);
      }catch (Exception e){
         throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
      }
   }
}
