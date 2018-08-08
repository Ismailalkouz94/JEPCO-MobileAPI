package com.bi.jepco.service.impl;


import com.bi.jepco.dao.BillhfDao;
import com.bi.jepco.dao.BillmfDao;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.BillmfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BillmfServiceImp implements BillmfService {

   @Autowired
   private BillmfDao billmfDao;

   @Autowired
   private BillhfDao billhfDao;


   @Override
   public Billmf find(CustomerSubAccount customerSubAccount) {

      Billmf billmf = billmfDao.find(customerSubAccount);

      if(billmf == null){
         throw new ResourceException(HttpStatus.NOT_FOUND , "file_not_found");
      }

      List<Billhf> billhfList = billhfDao.find(customerSubAccount);

      billmf.setBills(billhfList);

      return billmf;
   }
}
