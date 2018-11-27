package com.bi.jepco.service.impl;

import com.bi.jepco.dao.ReportProblemDao;
import com.bi.jepco.entities.ReportProblemLog;
import com.bi.jepco.service.ReportProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportProblemServiceImpl implements ReportProblemService {

    @Autowired
    ReportProblemDao reportProblemDao;

    @Override
    public ReportProblemLog saveLog(ReportProblemLog reportProblemLog) {
        return reportProblemDao.saveLog(reportProblemLog);
    }
}
