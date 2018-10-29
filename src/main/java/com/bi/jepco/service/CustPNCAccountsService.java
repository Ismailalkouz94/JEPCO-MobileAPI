package com.bi.jepco.service;

import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.resources.PncResource;

public interface CustPNCAccountsService {
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts);
    public PncResource send(PncResource pncResource);
}
