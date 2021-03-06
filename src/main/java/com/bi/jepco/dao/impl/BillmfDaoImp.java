package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.BillmfDao;
import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.BillmfPK;
import com.bi.jepco.entities.CustomerSubAccount;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BillmfDaoImp implements BillmfDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public Billmf find(CustomerSubAccount customerSubAccount) {

      BillmfPK billmfPK = new BillmfPK();
      billmfPK.setMCityNo(customerSubAccount.getCustomerSubInfoPK().getCity());
      billmfPK.setMRoundNo(customerSubAccount.getCustomerSubInfoPK().getRound());
      billmfPK.setMDeptNo(customerSubAccount.getCustomerSubInfoPK().getDept());
      billmfPK.setMCollNo(customerSubAccount.getCustomerSubInfoPK().getColl());
      billmfPK.setMConsNo(customerSubAccount.getCustomerSubInfoPK().getCons());

      return (Billmf) sessionFactory.getCurrentSession().createQuery("from Billmf billmf" +
              " where billmf.billmfPK = :billmfPK")
              .setParameter("billmfPK",billmfPK)
              .uniqueResult();
   }

}
