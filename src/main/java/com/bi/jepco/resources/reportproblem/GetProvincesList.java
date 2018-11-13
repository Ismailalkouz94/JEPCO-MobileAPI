package com.bi.jepco.resources.reportproblem;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Table")
public class GetProvincesList {

    private int branchId;
    private int code;
    private String desc1;
    private String country;
    private String ishq;
    private String desc2;
    private String logo;

    @XmlElement(name = "BranchID")
    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @XmlElement(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @XmlElement(name = "desc1")
    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    @XmlElement(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "ISHQ")
    public String getIshq() {
        return ishq;
    }

    public void setIshq(String ishq) {
        this.ishq = ishq;
    }

    @XmlElement(name = "desc2")
    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2;
    }

    @XmlElement(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
