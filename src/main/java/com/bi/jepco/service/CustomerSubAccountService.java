package com.bi.jepco.service;

import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;

import java.util.List;


public interface CustomerSubAccountService {

   public CustomerSubAccount create(CustomerSubAccount customerSubAccount);
   public List<CustomerSubAccount> find(CustomerProfile customerProfile);
   public CustomerSubAccount update(CustomerSubAccount customerSubAccount);
   public void delete(CustomerSubAccount customerSubAccount);
}
