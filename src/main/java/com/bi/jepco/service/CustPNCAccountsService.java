package com.bi.jepco.service;

import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.PNCLog;
import com.bi.jepco.resources.PncResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CustPNCAccountsService {
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts);
    public PncResource send(PncResource pncResource);
    public List<CustPNCAccounts> find(String fileNumber);
    public List<CustPNCAccounts> find();
    public int findCount(String platform);
    public int findLogCount();
    public String storePic(String pic,String picName) ;
    public List<PNCLog> findLog();

}
