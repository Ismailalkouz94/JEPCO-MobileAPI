package com.bi.jepco.dao;

import com.bi.jepco.entities.CustomerProfile;



public interface CustomerProfileDao {

   public CustomerProfile save(CustomerProfile customerProfile);
   public CustomerProfile find(String mobileNumber);


}
