package com.bi.jepco.dao;

import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.PNCLog;

import java.util.List;


public interface CustomerSubAccountDao {

   public CustomerSubAccount create(CustomerSubAccount customerSubAccount);
   public List<CustomerSubAccount> find(CustomerProfile customerProfile);
   public CustomerSubAccount find(CustomerProfile customerProfile, String fileNumber);
   public List<CustomerSubAccount> find(String fileNumber);
   public CustomerSubAccount update(CustomerSubAccount customerSubAccount);
   public void delete(CustomerSubAccount customerSubAccount);

}
