package com.bi.jepco.service.impl;

import com.bi.jepco.dao.CustPNCAccountsDao;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.service.CustPNCAccountsService;
import com.bi.jepco.utils.Utils;
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

        CustPNCAccounts pncAccounts = custPNCAccountsDao.find(custPNCAccounts.getCustomerProfile());
        if (pncAccounts != null) {
            pncAccounts.setOsVersion(custPNCAccounts.getOsVersion());
            pncAccounts.setToken(custPNCAccounts.getToken());
            pncAccounts.setPlatform(custPNCAccounts.getPlatform());
            return pncAccounts;
        } else {
//            custPNCAccounts.setId(Long.parseLong(Utils.randomNumber(5)));
            pncAccounts = custPNCAccountsDao.find(custPNCAccounts.getToken());
            if(pncAccounts !=null){
                pncAccounts.setOsVersion(custPNCAccounts.getOsVersion());
                pncAccounts.setCustomerProfile(custPNCAccounts.getCustomerProfile());
                pncAccounts.setPlatform(custPNCAccounts.getPlatform());
                return pncAccounts;
            }else {
                return custPNCAccountsDao.save(custPNCAccounts);
            }
        }
    }
}
