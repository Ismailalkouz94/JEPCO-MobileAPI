package com.bi.jepco.service;

import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.resources.PncResource;

import java.util.List;

public interface CustPNCAccountsService {
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts);
    public PncResource send(PncResource pncResource);
    public List<CustPNCAccounts> find(String fileNumber);
}
