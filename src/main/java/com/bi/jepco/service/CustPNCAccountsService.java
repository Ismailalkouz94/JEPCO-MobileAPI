package com.bi.jepco.service;

import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.resources.PncResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CustPNCAccountsService {
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts);
    public PncResource send(PncResource pncResource);
    public List<CustPNCAccounts> find(String fileNumber);
    public String storePic(MultipartFile pic) throws IOException;
}
