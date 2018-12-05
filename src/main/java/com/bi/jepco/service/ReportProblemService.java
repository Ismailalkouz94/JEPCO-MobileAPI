package com.bi.jepco.service;

import com.bi.jepco.entities.ReportProblemLog;

import java.util.List;

public interface ReportProblemService {
    public ReportProblemLog saveLog(ReportProblemLog reportProblemLog);
    public List<ReportProblemLog> findLog();

    public String storePic(String pic, String picName);

}
