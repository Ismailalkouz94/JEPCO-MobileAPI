package com.bi.jepco.service.impl;

import com.bi.jepco.dao.ReportProblemDao;
import com.bi.jepco.entities.ReportProblemLog;
import com.bi.jepco.service.ReportProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;

@Service
@Transactional
public class ReportProblemServiceImpl implements ReportProblemService {

    @Autowired
    ReportProblemDao reportProblemDao;

    @Override
    public ReportProblemLog saveLog(ReportProblemLog reportProblemLog) {
        return reportProblemDao.saveLog(reportProblemLog);
    }

    public String storePic(String pic, String picName) {
        try {
            String sourceFolder = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\ReportProblem-image\\";

            byte[] btDataFile = new sun.misc.BASE64Decoder().decodeBuffer(pic);

            File of = new File(sourceFolder + picName);
            FileOutputStream fos = new FileOutputStream(of);
            fos.write(btDataFile);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return picName;
    }
}
