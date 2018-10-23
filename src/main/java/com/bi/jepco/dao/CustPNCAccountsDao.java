package com.bi.jepco.dao;

import com.bi.jepco.entities.CustPNCAccounts;
public interface CustPNCAccountsDao   {

    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts);
    public CustPNCAccounts update(CustPNCAccounts custPNCAccounts);
    public CustPNCAccounts findById(CustPNCAccounts custPNCAccounts);
}
