package com.bi.jepco.dao.impl;

import com.bi.jepco.dao.ReportProblemDao;
import com.bi.jepco.entities.ReportProblemLog;
import com.bi.jepco.exception.ResourceException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportProblemDaoImpl implements ReportProblemDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ReportProblemLog saveLog(ReportProblemLog reportProblemLog) {
        try {
            sessionFactory.getCurrentSession().save(reportProblemLog);
            return reportProblemLog;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    public List<ReportProblemLog> findLog() {
        return sessionFactory.getCurrentSession().createQuery("from ReportProblemLog ORDER BY id DESC").list();
    }
}
