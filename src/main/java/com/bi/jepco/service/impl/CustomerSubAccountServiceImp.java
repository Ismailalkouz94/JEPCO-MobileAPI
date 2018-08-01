package com.bi.jepco.service.impl;

import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.service.CustomerSubAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerSubAccountServiceImp implements CustomerSubAccountService {

   @Autowired
   private CustomerSubAccountService customerSubAccountService;


   @Override
   public CustomerSubAccount create(CustomerSubAccount customerSubAccount) {
      return customerSubAccountService.create(customerSubAccount);
   }

   @Override
   public List<CustomerSubAccount> find(CustomerProfile customerProfile) {
      return customerSubAccountService.find(customerProfile);
   }

   @Override
   public CustomerSubAccount update(CustomerSubAccount customerSubAccount) {
      return customerSubAccountService.update(customerSubAccount);
   }
}
