package com.bi.jepco.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOB_PROBLEM_LOG")
public class ReportProblemLog {

    @Id
    @GeneratedValue()
    @Column(name = "P_LOG_ID")
    private Long id;

    @Column(name = "P_CUST_MOB_NO")
    private String mobileNumber;

    @Column(name = "P_CUST_NAME")
    private String name;

    @Column(name = "P_COUNTER_NO")
    private String counterNo;

    @Column(name = "P_PROVENCE_ID")
    private Integer provinceId;

    @Column(name = "P_PROVENCE_DESC")
    private String provinceDesc;

    @Column(name = "P_AREA_ID")
    private Integer areaId;

    @Column(name = "P_AREA_DESC")
    private String areaDesc;

    @Column(name = "P_HOOD_ID")
    private Integer neighborhoodId;

    @Column(name = "P_HOOD_DESC")
    private String neighborhoodDesc;

    @Column(name = "P_STREET_ID")
    private Integer streetId;

    @Column(name = "P_STREET_DESC")
    private String streetDesc;

    @Column(name = "P_FAILURE_TYPE")
    private String failureType;

    @Column(name = "P_ISSUE_TITLE")
    private String issueTitle;

    @Column(name = "P_DESC")
    private String description;

    @Column(name = "P_IMAGE")
    private String imagePath;

    @Column(name = "P_REF_NO")
    private String refNo;

    @Column(name = "P_TYPE")
    private String type;

    @Column(name = "P_DATE")
    @CreationTimestamp
    private LocalDateTime date;

    @Column(name = "P_STATUS")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounterNo() {
        return counterNo;
    }

    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Integer neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getProvinceDesc() {
        return provinceDesc;
    }

    public void setProvinceDesc(String provinceDesc) {
        this.provinceDesc = provinceDesc;
    }

    public String getAreaDesc() {
        return areaDesc;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc;
    }

    public String getNeighborhoodDesc() {
        return neighborhoodDesc;
    }

    public void setNeighborhoodDesc(String neighborhoodDesc) {
        this.neighborhoodDesc = neighborhoodDesc;
    }

    public String getStreetDesc() {
        return streetDesc;
    }

    public void setStreetDesc(String streetDesc) {
        this.streetDesc = streetDesc;
    }

    public String getFailureType() {
        return failureType;
    }

    public void setFailureType(String failureType) {
        this.failureType = failureType;
    }
}
