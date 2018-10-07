package com.bi.jepco.service;

import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface BillhfService {

   public List<Billhf> find(CustomerSubAccount customerSubAccount, Integer payFlag);
}
