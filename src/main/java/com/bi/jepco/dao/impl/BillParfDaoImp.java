package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.BillParfDao;
import com.bi.jepco.entities.BillParf;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BillParfDaoImp implements BillParfDao {

   @Autowired
   private SessionFactory sessionFactory;


   @Override
   public List<BillParf> find(Integer type) {
      System.out.println("type: "+type);
      List resultList = (List<BillParf>) sessionFactory.getCurrentSession()
              .createSQLQuery("SELECT  P_DATE as pDate , P_TYPE as pType , P_FROMKW as fromkw , P_TOKW as tokw , P_VALUE as pValue , PREV_VALUE as prevValue "
                      + " FROM TARIFFA"
                      + " WHERE P_TYPE = :type\n"
                      + " ORDER BY P_VALUE ASC ")
              .addScalar("pDate", new LocalDateType())
              .addScalar("pType", new IntegerType())
              .addScalar("fromkw", new DoubleType())
              .addScalar("tokw", new DoubleType())
              .addScalar("pValue", new DoubleType())
              .addScalar("prevValue", new DoubleType())
              .setResultTransformer(Transformers.aliasToBean(BillParf.class))
              .setParameter("type",type)
              .list();

      if (resultList != null && resultList.size() > 0) {
         return resultList;
      }
      return null;
   }
}
