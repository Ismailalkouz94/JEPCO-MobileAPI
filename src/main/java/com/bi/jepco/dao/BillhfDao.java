package com.bi.jepco.dao;

import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface BillhfDao {

   public List<Billhf> find(CustomerSubAccount customerSubAccount);

}
