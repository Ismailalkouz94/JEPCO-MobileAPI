package com.bi.jepco.service.impl;


import com.bi.jepco.dao.BillhfDao;
import com.bi.jepco.dao.BillmfDao;
import com.bi.jepco.entities.BillParf;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.BillmfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
      
      return billmf;
   }

   @Override
   public BigDecimal sliceCalculation(List<BillParf> parfList ,BigDecimal consumption) {
      BigDecimal result = new BigDecimal(0);
      for (BillParf billParf : parfList) {
         BigDecimal sliceResult = new BigDecimal((billParf.getTokw() - billParf.getFromkw()) + 1);
         if (consumption.compareTo(sliceResult) == -1) {
            //calculate the last tarifa
            result = result.add(consumption.multiply(new BigDecimal(billParf.getpValue())));
            break;
         }
         consumption = consumption.subtract(sliceResult);
         result = result.add(sliceResult.multiply(new BigDecimal(billParf.getpValue())));
      }
      return result.setScale(3,BigDecimal.ROUND_HALF_EVEN) ;
   }

}
