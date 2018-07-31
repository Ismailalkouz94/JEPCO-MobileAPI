package com.bi.jepco.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bi.jepco.entities.CustomerProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
