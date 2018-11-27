package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.CustPNCAccountsDao;
import com.bi.jepco.entities.CustPNCAccounts;
import com.bi.jepco.entities.CustomerProfile;
import com.bi.jepco.entities.PNCLog;
import com.bi.jepco.exception.ResourceException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

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
            e.printStackTrace();
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public CustPNCAccounts update(CustPNCAccounts custPNCAccounts) {
        try {
            sessionFactory.getCurrentSession().update(custPNCAccounts);
            return custPNCAccounts;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public CustPNCAccounts findById(CustPNCAccounts custPNCAccounts) {
        return (CustPNCAccounts) sessionFactory.getCurrentSession().find(CustPNCAccounts.class, custPNCAccounts.getToken());
    }

    @Override
    public CustPNCAccounts find(CustomerProfile customerProfile) {
        return (CustPNCAccounts) sessionFactory.getCurrentSession().createQuery("from CustPNCAccounts PNC" +
                " where PNC.customerProfile = :customerProfile")
                .setParameter("customerProfile", customerProfile)
                .uniqueResult();
    }

    @Override
    public CustPNCAccounts find(String token) {
        return (CustPNCAccounts) sessionFactory.getCurrentSession().createQuery("from CustPNCAccounts PNC" +
                " where PNC.token = :token")
                .setParameter("token", token)
                .uniqueResult();
    }

    @Override
    public List<CustPNCAccounts> find() {
        return sessionFactory.getCurrentSession().createQuery("FROM CustPNCAccounts").list();
    }

    @Override
    public void delete(CustPNCAccounts custPNCAccounts) {
        try {
            sessionFactory.getCurrentSession().delete(custPNCAccounts);

        } catch (Exception e) {
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public PNCLog saveLog(PNCLog pncLog) {
        try {
            sessionFactory.getCurrentSession().save(pncLog);
            return pncLog;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

