package com.bi.jepco.service;

import com.bi.jepco.entities.CustomerProfile;



public interface CustomerProfileService {

   public CustomerProfile create(CustomerProfile customerProfile);

   public CustomerProfile find(String nationalNumber);
   public CustomerProfile verify(CustomerProfile customerProfile);

}
