package com.bi.jepco.dao;

import com.bi.jepco.entities.ReportProblemLog;

import java.util.List;

public interface ReportProblemDao {
    public ReportProblemLog saveLog(ReportProblemLog reportProblemLog);
    public List<ReportProblemLog> findLog();

}
