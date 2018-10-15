package com.bi.jepco.service;

import com.bi.jepco.entities.BillParf;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface BillParfService {

   public List<BillParf> find(Integer type);
   public List<BillParf> find();
}
