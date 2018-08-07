package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.MobileTipsDao;
import com.bi.jepco.entities.MobileTips;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MobileTipsDaoImp implements MobileTipsDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public List<MobileTips> find() {
      return sessionFactory.getCurrentSession().createQuery("from MobileTips").list();
   }
}
