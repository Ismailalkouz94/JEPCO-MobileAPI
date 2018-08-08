package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.BillhfDao;
import com.bi.jepco.entities.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class BillhfDaoImp implements BillhfDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public List<Billhf> find(CustomerSubAccount customerSubAccount) {

      BillhfPK billhfPK = new BillhfPK();
      billhfPK.sethCityNo(customerSubAccount.getCity());
      billhfPK.sethRoundNo(customerSubAccount.getRound());
      billhfPK.sethDeptNo(customerSubAccount.getDept());
      billhfPK.sethCollNo(customerSubAccount.getColl());
      billhfPK.sethConsNo(customerSubAccount.getCons());

      List<Billhf> billhfList =  sessionFactory.getCurrentSession().createQuery("from Billhf bill" +
              " where bill.billhfPK.hCityNo = :cityNo" +
              " and bill.billhfPK.hRoundNo = :roundNo" +
              " and bill.billhfPK.hDeptNo = :deptNo" +
              " and bill.billhfPK.hCollNo = :collNo" +
              " and bill.billhfPK.hConsNo = :consNo")
              .setParameter("cityNo",billhfPK.gethCityNo())
              .setParameter("roundNo",billhfPK.gethRoundNo())
              .setParameter("deptNo",billhfPK.gethDeptNo())
              .setParameter("collNo",billhfPK.gethCollNo())
              .setParameter("consNo",billhfPK.gethConsNo())
              .list();

       return billhfList;
   }
}
