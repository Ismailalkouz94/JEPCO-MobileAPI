package com.bi.jepco.service;

import com.bi.jepco.entities.BillParf;
import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerSubAccount;

import java.math.BigDecimal;
import java.util.List;


public interface BillmfService {

   public Billmf find(CustomerSubAccount customerSubAccount);
   public BigDecimal sliceCalculation(List<BillParf> parfList,BigDecimal consumption);

}
