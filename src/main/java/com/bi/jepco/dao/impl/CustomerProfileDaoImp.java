package com.bi.jepco.dao.impl;

import com.bi.jepco.entities.CustomerProfile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bi.jepco.dao.CustomerProfileDao;



@Repository
public class CustomerProfileDaoImp implements CustomerProfileDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public Long save(CustomerProfile customerProfile) {
      sessionFactory.getCurrentSession().save(customerProfile);
      return customerProfile.getId();
   }

}