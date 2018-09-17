package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.BillParfDao;
import com.bi.jepco.dao.BillhfDao;
import com.bi.jepco.entities.BillParf;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.BillhfPK;
import com.bi.jepco.entities.CustomerSubAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BillParfDaoImp implements BillParfDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public BillParf find() {
      List<BillParf> billParfList= sessionFactory.getCurrentSession().createQuery("from BillParf where billPf" +
              " billPf.date = (select max(bPf.date) from BillParf bPf) ").list();
      return billParfList.get(0);
   }
}
