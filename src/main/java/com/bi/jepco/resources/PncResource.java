package com.bi.jepco.resources;

import org.springframework.web.multipart.MultipartFile;

public class PncResource {
    private String toFlaq;
    private String mobileNumber;
    private String fileNumber;
    private String title;
    private String message;

    public String getToFlaq() {
        return toFlaq;
    }

    public void setToFlaq(String toFlaq) {
        this.toFlaq = toFlaq;
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


}
