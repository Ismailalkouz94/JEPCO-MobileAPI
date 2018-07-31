package com.bi.jepco.service.impl;

import java.util.List;

import com.bi.jepco.entities.CustomerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bi.jepco.dao.CustomerProfileDao;
import com.bi.jepco.service.CustomerProfileService;


@Service
@Transactional
public class CustomerProfileServiceImp implements CustomerProfileService {

   @Autowired
   private CustomerProfileDao customerProfileDao;

   @Override
   public Long save(CustomerProfile customerProfile) {

      return customerProfileDao.save(customerProfile);
   }


}
