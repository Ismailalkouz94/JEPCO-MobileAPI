package com.bi.jepco.service;

import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface BillmfService {

   public Billmf find(CustomerSubAccount customerSubAccount);

}
