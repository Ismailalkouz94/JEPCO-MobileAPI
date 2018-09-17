package com.bi.jepco.service.impl;


import com.bi.jepco.dao.BillParfDao;
import com.bi.jepco.entities.BillParf;
import com.bi.jepco.service.BillParfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BillhfServiceImp implements BillParfService {

   @Autowired
   private BillParfDao billParfDao;


   @Override
   public BillParf find() {
      return billParfDao.find();
   }
}
