package com.bi.jepco.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOB_PNC_LOG")
public class PNCLog {

    @Id
    @GeneratedValue()
    @Column(name = "PNC_LOG_ID")
    private Long id;

    @Column(name = "PNC_CUST_MOB_NO")
    private String mobileNumber;

    @Column(name = "PNC_FILE_NO")
    private String fileNumber;

    @Column(name = "PNC_TOKEN")
    private String token;

    @Column(name = "PNC_TITLE")
    private String title;

    @Column(name = "PNC_MSG")
    private String message;

    @Column(name = "PNC_IMAGE")
    private String imagePath;

    @Column(name = "PNC_PLATFORM")
    private String platform;

    @Column(name = "PNC_OS_VER")
    private String osVersion;

    @Column(name = "PNC_DATE")
    @CreationTimestamp
    private LocalDateTime date;


    @Column(name = "PNC_STATUS")
    private int status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
