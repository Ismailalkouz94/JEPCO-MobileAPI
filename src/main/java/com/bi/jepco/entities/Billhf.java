package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "BILLHF")
public class Billhf implements Serializable {

    @EmbeddedId
    protected BillhfPK billhfPK;

    @Column(name = "H_CITY_NO_AL")
    private Integer cityAl;

    @Column(name = "H_ROUND_NO_AL")
    private Integer roundAL;

    @Column(name = "H_SUB_R_NO_AL")
    private Integer subNoAl;

    @Column(name = "H_DEPT_NO_AL")
    private Integer deptAl;

    @Column(name = "H_COLL_NO_AL")
    private Integer collAl;

    @Column(name = "H_CONS_NO_AL")
    private Integer consAl;

    @Column(name = "H_TRANS_DATE" )
    private LocalDate transDate;

    @Column(name = "H_PREVIOUS_READ" )
    private Long previousRead;

    @Column(name = "H_PREV_READ_DATE" )
    @JsonIgnore
    private LocalDate previousReadDate;

    @Column(name = "H_CUR_READ" )
    private Long currentRead;

    @Column(name = "H_CUR_READ_DATE" )
    private LocalDate currentReadDate;

    @Column(name = "H_CONSUM_QTY" )
    private Long consumeQty;

    @Column(name = "H_CONSUM_VALUE" )
    private Double consumeValue;

    @Column(name = "H_DIS_VALUE" )
    private Long disValue;

    @Column(name = "H_METER_VALUE" )
    private Double meterValue;

    @Column(name = "H_ADD_TAX" )
    private Double addTax;

    @Column(name = "H_FILS_TAX" )
    private Double filsTax;

    @Column(name = "H_TELEVISION_TAX" )
    private Double televisionTax;

    @Column(name = "H_GAR_VALUE" )
    private Double garValue;

    @Column(name = "H_AD_PAY_VALUE" )
    private Double adPayValue;

    @Column(name = "H_BIL_REQ_VALUE" )
    private Double billReqValue;

    @Column(name = "H_GAR_CITY" )
    private Integer garCity;

    @Column(name = "H_GAR_DEPT" )
    private Integer garDept;

    @Column(name = "H_GAR" )
    private Integer gar;

    @Column(name = "H_CONS_TYPE_DUE" )
    private Integer consTypeDue;

    @Column(name = "H_FILS" )
    private Integer fils;

    @Column(name = "H_CONS_TYPE" )
    private Integer consType;

    @Column(name = "H_FAZ" )
    private Integer faz;

    @Column(name = "H_DISCOUNT" )
    private Double discount;

    @Column(name = "H_FAC_PRD" )
    private Double facPrd;

    @Column(name = "H_TV_CODE" )
    private Integer tvCode;

    @Column(name = "H_ADD_TAX_CODE" )
    private Integer addTaxCode;

    @Column(name = "H_BIL_CODE" )
    private Integer billCode;

    @Column(name = "H_PAY_DATE" )
    private LocalDate payDate;

    @Column(name = "H_COLL_T" )
    private Integer collT;

    @Column(name = "H_COLL_CODE1" )
    private Integer collCode1;

    @Column(name = "H_COLL_CODE2" )
    private Integer collCode2;

    @Column(name = "H_ES_VALUE" )
    private Double esValue;

    @Column(name = "H_ES_QTY" )
    private Long esQty;

    @Column(name = "H_LOSES_POWER" )
    private Integer loserPower;

    @Column(name = "IP_ADDRESS" )
    private String ipAddress;

    @Column(name = "PC_NAME" )
    private String pcName;

    @Column(name = "PC_USER" )
    private String pcUser;

    @Column(name = "ORA_USER" )
    private String oraUser;

    @Column(name = "H_LOS_FLAG" )
    private Integer losFlag;

    @Column(name = "H_LOS_QTY" )
    private Long losQty;

    @Column(name = "H_TRANSIT_FLAG" )
    private Integer transitFlag;

    @Column(name = "H_TRANSIT_AMT" )
    private Double transitAmt;

    @Column(name = "H_PETROL_TAX" )
    private Double petrolTax;


    public BillhfPK getBillhfPK() {
        return billhfPK;
    }

    public void setBillhfPK(BillhfPK billhfPK) {
        this.billhfPK = billhfPK;
    }

    public Integer getCityAl() {
        return cityAl;
    }

    public void setCityAl(Integer cityAl) {
        this.cityAl = cityAl;
    }

    public Integer getRoundAL() {
        return roundAL;
    }

    public void setRoundAL(Integer roundAL) {
        this.roundAL = roundAL;
    }

    public Integer getSubNoAl() {
        return subNoAl;
    }

    public void setSubNoAl(Integer subNoAl) {
        this.subNoAl = subNoAl;
    }

    public Integer getDeptAl() {
        return deptAl;
    }

    public void setDeptAl(Integer deptAl) {
        this.deptAl = deptAl;
    }

    public Integer getCollAl() {
        return collAl;
    }

    public void setCollAl(Integer collAl) {
        this.collAl = collAl;
    }

    public Integer getConsAl() {
        return consAl;
    }

    public void setConsAl(Integer consAl) {
        this.consAl = consAl;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    public Long getPreviousRead() {
        return previousRead;
    }

    public void setPreviousRead(Long previousRead) {
        this.previousRead = previousRead;
    }

    public LocalDate getPreviousReadDate() {
        return previousReadDate;
    }

    public void setPreviousReadDate(LocalDate previousReadDate) {
        this.previousReadDate = previousReadDate;
    }

    public Long getCurrentRead() {
        return currentRead;
    }

    public void setCurrentRead(Long currentRead) {
        this.currentRead = currentRead;
    }

    public LocalDate getCurrentReadDate() {
        return currentReadDate;
    }

    public void setCurrentReadDate(LocalDate currentReadDate) {
        this.currentReadDate = currentReadDate;
    }

    public Long getConsumeQty() {
        return consumeQty;
    }

    public void setConsumeQty(Long consumeQty) {
        this.consumeQty = consumeQty;
    }

    public Double getConsumeValue() {
        return consumeValue;
    }

    public void setConsumeValue(Double consumeValue) {
        this.consumeValue = consumeValue;
    }

    public Long getDisValue() {
        return disValue;
    }

    public void setDisValue(Long disValue) {
        this.disValue = disValue;
    }

    public Double getMeterValue() {
        return meterValue;
    }

    public void setMeterValue(Double meterValue) {
        this.meterValue = meterValue;
    }

    public Double getAddTax() {
        return addTax;
    }

    public void setAddTax(Double addTax) {
        this.addTax = addTax;
    }

    public Double getFilsTax() {
        return filsTax;
    }

    public void setFilsTax(Double filsTax) {
        this.filsTax = filsTax;
    }

    public Double getTelevisionTax() {
        return televisionTax;
    }

    public void setTelevisionTax(Double televisionTax) {
        this.televisionTax = televisionTax;
    }

    public Double getGarValue() {
        return garValue;
    }

    public void setGarValue(Double garValue) {
        this.garValue = garValue;
    }

    public Double getAdPayValue() {
        return adPayValue;
    }

    public void setAdPayValue(Double adPayValue) {
        this.adPayValue = adPayValue;
    }

    public Double getBillReqValue() {
        return billReqValue;
    }

    public void setBillReqValue(Double billReqValue) {
        this.billReqValue = billReqValue;
    }

    public Integer getGarCity() {
        return garCity;
    }

    public void setGarCity(Integer garCity) {
        this.garCity = garCity;
    }

    public Integer getGarDept() {
        return garDept;
    }

    public void setGarDept(Integer garDept) {
        this.garDept = garDept;
    }

    public Integer getGar() {
        return gar;
    }

    public void setGar(Integer gar) {
        this.gar = gar;
    }

    public Integer getConsTypeDue() {
        return consTypeDue;
    }

    public void setConsTypeDue(Integer consTypeDue) {
        this.consTypeDue = consTypeDue;
    }

    public Integer getFils() {
        return fils;
    }

    public void setFils(Integer fils) {
        this.fils = fils;
    }

    public Integer getConsType() {
        return consType;
    }

    public void setConsType(Integer consType) {
        this.consType = consType;
    }

    public Integer getFaz() {
        return faz;
    }

    public void setFaz(Integer faz) {
        this.faz = faz;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getFacPrd() {
        return facPrd;
    }

    public void setFacPrd(Double facPrd) {
        this.facPrd = facPrd;
    }

    public Integer getTvCode() {
        return tvCode;
    }

    public void setTvCode(Integer tvCode) {
        this.tvCode = tvCode;
    }

    public Integer getAddTaxCode() {
        return addTaxCode;
    }

    public void setAddTaxCode(Integer addTaxCode) {
        this.addTaxCode = addTaxCode;
    }

    public Integer getBillCode() {
        return billCode;
    }

    public void setBillCode(Integer billCode) {
        this.billCode = billCode;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public Integer getCollT() {
        return collT;
    }

    public void setCollT(Integer collT) {
        this.collT = collT;
    }

    public Integer getCollCode1() {
        return collCode1;
    }

    public void setCollCode1(Integer collCode1) {
        this.collCode1 = collCode1;
    }

    public Integer getCollCode2() {
        return collCode2;
    }

    public void setCollCode2(Integer collCode2) {
        this.collCode2 = collCode2;
    }

    public Double getEsValue() {
        return esValue;
    }

    public void setEsValue(Double esValue) {
        this.esValue = esValue;
    }

    public Long getEsQty() {
        return esQty;
    }

    public void setEsQty(Long esQty) {
        this.esQty = esQty;
    }

    public Integer getLoserPower() {
        return loserPower;
    }

    public void setLoserPower(Integer loserPower) {
        this.loserPower = loserPower;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getPcUser() {
        return pcUser;
    }

    public void setPcUser(String pcUser) {
        this.pcUser = pcUser;
    }

    public String getOraUser() {
        return oraUser;
    }

    public void setOraUser(String oraUser) {
        this.oraUser = oraUser;
    }

    public Integer getLosFlag() {
        return losFlag;
    }

    public void setLosFlag(Integer losFlag) {
        this.losFlag = losFlag;
    }

    public Long getLosQty() {
        return losQty;
    }

    public void setLosQty(Long losQty) {
        this.losQty = losQty;
    }

    public Integer getTransitFlag() {
        return transitFlag;
    }

    public void setTransitFlag(Integer transitFlag) {
        this.transitFlag = transitFlag;
    }

    public Double getTransitAmt() {
        return transitAmt;
    }

    public void setTransitAmt(Double transitAmt) {
        this.transitAmt = transitAmt;
    }

    public Double getPetrolTax() {
        return petrolTax;
    }

    public void setPetrolTax(Double petrolTax) {
        this.petrolTax = petrolTax;
    }
}
