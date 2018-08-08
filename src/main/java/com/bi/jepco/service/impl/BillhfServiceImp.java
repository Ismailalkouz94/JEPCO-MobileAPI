package com.bi.jepco.service.impl;


import com.bi.jepco.dao.BillhfDao;
import com.bi.jepco.dao.MobileTipsDao;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.MobileTips;
import com.bi.jepco.service.BillhfService;
import com.bi.jepco.service.MobileTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BillhfServiceImp implements BillhfService {

   @Autowired
   private BillhfDao billhfDao;


   @Override
   public List<Billhf> find(CustomerSubAccount customerSubAccount) {
      return billhfDao.find(customerSubAccount);
   }
}
