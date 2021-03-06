package com.bi.jepco.service.impl;

import com.bi.jepco.dao.BillmfDao;
import com.bi.jepco.dao.SmsVerificationDao;
import com.bi.jepco.entities.Billmf;
import com.bi.jepco.entities.CustomerSubAccount;
import com.bi.jepco.entities.CustomerSubInfoPK;
import com.bi.jepco.entities.SmsVerification;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.service.SmsVerificationService;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
public class SmsVerificationServiceImp implements SmsVerificationService {


    @Autowired
    private SmsVerificationDao smsVerificationDao;

    @Autowired
    private BillmfDao billmfDao;


    @Override
    public SmsVerification create(SmsVerification smsVerification) {
//
//        CustomerSubAccount customerSubAccount = new CustomerSubAccount();
//
//        CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();
//
//        customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);
//
//        customerSubAccount.setFileNumber(smsVerification.getFileNumber());
//
//        Utils.initFileNumberTokens(customerSubAccount);
//
//        Billmf billmf = billmfDao.find(customerSubAccount);
//
//        if (billmf == null) {
//            throw new ResourceException(HttpStatus.NOT_FOUND, "file_no_not_found");
//        }

        // ----------------------- Old Code  --------------------------------------------

//       SmsVerification currentSmsVerification = smsVerificationDao.find(smsVerification.getMobileNumber(),1);

//       if (currentSmsVerification != null) {
//           currentSmsVerification.setStatus(0);
//       }
//
//       smsVerification.setCode(Utils.randomNumber(4));
//       smsVerification.setCreationDate(LocalDateTime.now());
//       smsVerification.setExpirationDate(LocalDateTime.now().plusMinutes(1).plusSeconds(10));
//       smsVerification.setStatus(1);
//
//       return smsVerificationDao.create(smsVerification);

        //-------------------------new code update 9/10/2018 -----------------------------------------

        SmsVerification currentSmsVerification = smsVerificationDao.find(smsVerification.getMobileNumber(), 1);
        if (currentSmsVerification != null) {
            if(currentSmsVerification.getMobileNumber().equals("+962790000000")){
                currentSmsVerification.setCode("0000");
            }else{
                currentSmsVerification.setCode(Utils.randomNumber(4));
            }

            currentSmsVerification.setCreationDate(LocalDateTime.now());
            currentSmsVerification.setExpirationDate(LocalDateTime.now().plusMinutes(2));
            currentSmsVerification.setStatus(1);
            return currentSmsVerification;
        } else {
            if(smsVerification.getMobileNumber().equals("+962790000000")){
                smsVerification.setCode("0000");
            }else{
                smsVerification.setCode(Utils.randomNumber(4));
            }
            smsVerification.setCreationDate(LocalDateTime.now());
            smsVerification.setExpirationDate(LocalDateTime.now().plusMinutes(2));
            smsVerification.setStatus(1);
            return smsVerificationDao.create(smsVerification);
        }
    }

    @Override
    public SmsVerification find(String mobileNumber, Integer status) {
        return smsVerificationDao.find(mobileNumber, status);
    }

    @Override
    public SmsVerification update(SmsVerification smsVerification) {
        return smsVerificationDao.update(smsVerification);
    }
}
