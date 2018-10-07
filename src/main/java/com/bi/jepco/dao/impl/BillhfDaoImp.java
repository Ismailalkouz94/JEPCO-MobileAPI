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
   public List<Billhf> find(CustomerSubAccount customerSubAccount, Integer payFlag) {

      BillhfPK billhfPK = new BillhfPK();
      billhfPK.sethCityNo(customerSubAccount.getCustomerSubInfoPK().getCity());
      billhfPK.sethRoundNo(customerSubAccount.getCustomerSubInfoPK().getRound());
      billhfPK.sethDeptNo(customerSubAccount.getCustomerSubInfoPK().getDept());
      billhfPK.sethCollNo(customerSubAccount.getCustomerSubInfoPK().getColl());
      billhfPK.sethConsNo(customerSubAccount.getCustomerSubInfoPK().getCons());

      List<Billhf> billhfList = null;

      switch(payFlag){
         case 1:    billhfList =  sessionFactory.getCurrentSession().createQuery("from Billhf bill" +
                    " where bill.billhfPK.hCityNo = :cityNo" +
                    " and bill.billhfPK.hRoundNo = :roundNo" +
                    " and bill.billhfPK.hDeptNo = :deptNo" +
                    " and bill.billhfPK.hCollNo = :collNo" +
                    " and bill.billhfPK.hConsNo = :consNo" +
                    " and bill.payDate is null" +
                    " order by bill.billhfPK.hBillNo desc")
                    .setParameter("cityNo",billhfPK.gethCityNo())
                    .setParameter("roundNo",billhfPK.   gethRoundNo())
                    .setParameter("deptNo",billhfPK.gethDeptNo())
                    .setParameter("collNo",billhfPK.gethCollNo())
                    .setParameter("consNo",billhfPK.gethConsNo())
                    .list();
            break;
         case 2: billhfList =  sessionFactory.getCurrentSession().createQuery("from Billhf bill" +
                 " where bill.billhfPK.hCityNo = :cityNo" +
                 " and bill.billhfPK.hRoundNo = :roundNo" +
                 " and bill.billhfPK.hDeptNo = :deptNo" +
                 " and bill.billhfPK.hCollNo = :collNo" +
                 " and bill.billhfPK.hConsNo = :consNo" +
                 " and bill.payDate is not null" +
                 " order by bill.billhfPK.hBillNo desc")
                 .setParameter("cityNo",billhfPK.gethCityNo())
                 .setParameter("roundNo",billhfPK.gethRoundNo())
                 .setParameter("deptNo",billhfPK.gethDeptNo())
                 .setParameter("collNo",billhfPK.gethCollNo())
                 .setParameter("consNo",billhfPK.gethConsNo())
                 .setMaxResults(12)
                 .list();
            break;
            default: billhfList =  sessionFactory.getCurrentSession().createQuery("from Billhf bill" +
                       " where bill.billhfPK.hCityNo = :cityNo" +
                       " and bill.billhfPK.hRoundNo = :roundNo" +
                       " and bill.billhfPK.hDeptNo = :deptNo" +
                       " and bill.billhfPK.hCollNo = :collNo" +
                       " and bill.billhfPK.hConsNo = :consNo" +
                       " order by bill.billhfPK.hBillNo desc")
                       .setParameter("cityNo",billhfPK.gethCityNo())
                       .setParameter("roundNo",billhfPK.gethRoundNo())
                       .setParameter("deptNo",billhfPK.gethDeptNo())
                       .setParameter("collNo",billhfPK.gethCollNo())
                       .setParameter("consNo",billhfPK.gethConsNo())
                       .setMaxResults(12)
                       .list();
            break;
      }

       return billhfList;
   }
}
