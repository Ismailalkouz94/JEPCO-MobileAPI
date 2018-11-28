package com.bi.jepco.service;

import com.bi.jepco.entities.ReportProblemLog;

public interface ReportProblemService {
    public ReportProblemLog saveLog(ReportProblemLog reportProblemLog);
    public String storePic(String pic, String picName);

}
