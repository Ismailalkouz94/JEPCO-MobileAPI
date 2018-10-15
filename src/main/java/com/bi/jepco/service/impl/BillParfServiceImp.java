package com.bi.jepco.service.impl;


import com.bi.jepco.dao.BillParfDao;
import com.bi.jepco.dao.BillhfDao;
import com.bi.jepco.entities.BillParf;
import com.bi.jepco.entities.Billhf;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.service.BillParfService;
import com.bi.jepco.service.BillhfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BillParfServiceImp implements BillParfService {

    @Autowired
    private BillParfDao billParfDao;


    @Override
    public List<BillParf> find(Integer type) {
        return billParfDao.find(type);
    }

    @Override
    public List<BillParf> find() {
        return billParfDao.find();
    }
}
