package com.bi.jepco.dao.impl;

import com.bi.jepco.config.MessageBody;
import com.bi.jepco.dao.CustPNCAccountsDao;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.exception.ResourceException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class CustPNCAccountsDaoImpl implements CustPNCAccountsDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CustPNCAccounts save(CustPNCAccounts custPNCAccounts) {
        try {
            sessionFactory.getCurrentSession().save(custPNCAccounts);
            return custPNCAccounts;
        } catch (Exception e) {
            throw new ResourceException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
