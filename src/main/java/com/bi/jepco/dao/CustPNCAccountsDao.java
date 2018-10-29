package com.bi.jepco.dao;

import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.CustomerProfile;

import java.util.List;

public interface CustPNCAccountsDao   {

    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts);
    public CustPNCAccounts update(CustPNCAccounts custPNCAccounts);
    public CustPNCAccounts findById(CustPNCAccounts custPNCAccounts);
    public CustPNCAccounts find(CustomerProfile customerProfile);
    public CustPNCAccounts find(String token);
    public List<CustPNCAccounts> find();

    public void delete(CustPNCAccounts custPNCAccounts);
}
