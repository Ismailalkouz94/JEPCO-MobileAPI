package com.bi.jepco.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bi.jepco.dao.BillmfDao;
import com.bi.jepco.dao.CustomerSubAccountDao;
import com.bi.jepco.dao.SmsVerificationDao;
import com.bi.jepco.entities.*;
import com.bi.jepco.exception.ResourceException;
import com.bi.jepco.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bi.jepco.dao.CustomerProfileDao;
import com.bi.jepco.service.CustomerProfileService;


@Service
@Transactional
public class CustomerProfileServiceImp implements CustomerProfileService {

    @Autowired
    private CustomerProfileDao customerProfileDao;

    @Autowired
    private CustomerSubAccountDao customerSubAccountDao;

    @Autowired
    private SmsVerificationDao smsVerificationDao;

    @Autowired
    private BillmfDao billmfDao;

    @Override
    public CustomerProfile create(CustomerProfile customerProfile) {

        customerProfile.setCreationDate(LocalDateTime.now());

        customerProfile.setStatus(1);

        customerProfileDao.save(customerProfile);

        CustomerSubAccount customerSubAccount = new CustomerSubAccount();

        CustomerSubInfoPK customerSubInfoPK = new CustomerSubInfoPK();

        customerSubAccount.setCustomerSubInfoPK(customerSubInfoPK);

        customerSubAccount.setFileNumber(customerProfile.getFileNumber());

        Utils.initFileNumberTokens(customerSubAccount);

        Billmf billmf = billmfDao.find(customerSubAccount);

        if (billmf == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "file_no_not_found");
        }

        customerSubAccount.getCustomerSubInfoPK().setCustomerProfile(customerProfile);

        customerSubAccount.setCreationDate(LocalDateTime.now());

        customerSubAccount.setAlias(customerProfile.getFirstName() + " " + customerProfile.getLastName());

        customerSubAccountDao.create(customerSubAccount);

        List<CustomerSubAccount> customerSubAccountsList = customerSubAccountDao.find(customerProfile);

        customerProfile.setCustomerSubAccountList(customerSubAccountsList);

        return customerProfile;
    }

    @Override
    public CustomerProfile verify(CustomerProfile customerProfile) {

        String mobileValidator = Utils.formatE164("+962", customerProfile.getMobileNumber());

        if (mobileValidator.equals("0")) {
            throw new ResourceException(HttpStatus.BAD_REQUEST, "invalid_mobile");
        }

        customerProfile.setMobileNumber(mobileValidator);

        SmsVerification smsVerification = smsVerificationDao.find(customerProfile.getMobileNumber(), 1);

        if (smsVerification == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "sms_code_not_found");
        }

        if (smsVerification.getExpirationDate().isBefore(LocalDateTime.now())) {
            throw new ResourceException(HttpStatus.FORBIDDEN, "sms_code_expired");
        }

        if (!smsVerification.getCode().equals(customerProfile.getCode())) {
            throw new ResourceException(HttpStatus.NOT_ACCEPTABLE, "sms_code_invalid");
        }

        smsVerification.setStatus(2);

        smsVerification.setUsedDate(LocalDateTime.now());

        CustomerProfile currentCustomerProfile = customerProfileDao.find(customerProfile.getMobileNumber());
        System.out.println(">> mobile number "+customerProfile.getMobileNumber());
        System.out.println(">> currentCustomerProfile "+currentCustomerProfile);
        if (currentCustomerProfile == null) {
            return null;
        } else {
            List<CustomerSubAccount> customerSubAccounts = customerSubAccountDao.find(currentCustomerProfile);
            currentCustomerProfile.setCustomerSubAccountList(customerSubAccounts);

            return currentCustomerProfile;
        }
    }

    @Override
    public CustomerProfile find(String mobileNumber) {
        CustomerProfile customerProfile = customerProfileDao.find(mobileNumber);

        if (customerProfile == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "profile_not_found");
        }

        List<CustomerSubAccount> customerSubAccountList = customerSubAccountDao.find(customerProfile);

        customerProfile.setCustomerSubAccountList(customerSubAccountList);

        return customerProfile;
    }


}
