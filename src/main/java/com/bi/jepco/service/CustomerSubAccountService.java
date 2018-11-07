package com.bi.jepco.service;

import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface CustomerSubAccountService {

   public CustomerSubAccount create(CustomerSubAccount customerSubAccount);
   public List<CustomerSubAccount> find(CustomerProfile customerProfile);
   public List<CustomerSubAccount> find(String fileNumber);
   public CustomerSubAccount update(String oldFileNumber ,CustomerSubAccount customerSubAccount);
   public void delete(CustomerProfile customerProfile,String customerSubAccountFileNumber);
}
