package com.bi.jepco.dao;

import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerSubAccount;


public interface BillmfDao {

   public Billmf find(CustomerSubAccount customerSubAccount);

}
