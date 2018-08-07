package com.bi.jepco.dao;

import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface CustomerSubAccountDao {

   public CustomerSubAccount create(CustomerSubAccount customerSubAccount);
   public List<CustomerSubAccount> find(CustomerProfile customerProfile);
   public CustomerSubAccount find(Long id);
   public CustomerSubAccount find(CustomerProfile customerProfile, String fileNumber);
   public CustomerSubAccount update(CustomerSubAccount customerSubAccount);
   public void delete(CustomerSubAccount customerSubAccount);
}
