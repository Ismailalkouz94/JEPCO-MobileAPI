package com.bi.jepco.service.impl;


import com.bi.jepco.dao.MobileTipsDao;
import com.bi.jepco.entities.MobileTips;
import com.bi.jepco.service.MobileTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MobileTipsServiceImp implements MobileTipsService {

   @Autowired
   private MobileTipsDao mobileTipsDao;


   @Override
   public List<MobileTips> find() {
      return mobileTipsDao.find();
   }
}
