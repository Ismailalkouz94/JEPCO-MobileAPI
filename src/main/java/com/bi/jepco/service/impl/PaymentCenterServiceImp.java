package com.bi.jepco.service.impl;


import com.bi.jepco.dao.PaymentCenterDao;
import com.bi.jepco.entities.PaymentCenter;
import com.bi.jepco.service.PaymentCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PaymentCenterServiceImp implements PaymentCenterService {

   @Autowired
   private PaymentCenterDao paymentCenterDao;


   @Override
   public List<PaymentCenter> find() {
      return paymentCenterDao.find();
   }
}
