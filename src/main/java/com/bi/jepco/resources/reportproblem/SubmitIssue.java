package com.bi.jepco.resources.reportproblem;

public class SubmitIssue {

    private String requesterMobile;
    private String requesterName;

    //RequesterTel
    private String counterNumber;

    //branchId
    private Integer provinceId;
    private String provinceDesc;

    //ServiceID
    private Integer areaId;
    private String areaDesc;

    //CategoryID
    private Integer neighborhoodId;
    private String neighborhoodDesc;

    //SubCategoryID
    private Integer streetId;
    private String streetDesc;

    private String description;

    private String attachName;
    private String attachValue;

    private String failureType;


    public String getRequesterMobile() {
        return requesterMobile;
    }

    public void setRequesterMobile(String requesterMobile) {
        this.requesterMobile = requesterMobile;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getCounterNumber() {
        return counterNumber;
    }

    public void setCounterNumber(String counterNumber) {
        this.counterNumber = counterNumber;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachValue() {
        return attachValue;
    }

    public void setAttachValue(String attachValue) {
        this.attachValue = attachValue;
    }

    public String getFailureType() {
        return failureType;
    }

    public void setFailureType(String failureType) {
        this.failureType = failureType;
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
}
