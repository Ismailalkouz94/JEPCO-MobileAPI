package com.bi.jepco.service.impl;

import com.bi.jepco.dao.CustPNCAccountsDao;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.service.CustPNCAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustPNCAccountsServiceImpl implements CustPNCAccountsService {

    @Autowired
    private CustPNCAccountsDao custPNCAccountsDao;

    @Override
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts) {
        CustPNCAccounts pncAccounts = custPNCAccountsDao.findById(custPNCAccounts);
        if (pncAccounts != null) {
            return custPNCAccountsDao.update(pncAccounts);
        } else {
            return custPNCAccountsDao.save(custPNCAccounts);
        }
    }
}
