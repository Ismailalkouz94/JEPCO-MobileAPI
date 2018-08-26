package com.bi.jepco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "BILPARF")
public class BillParf implements Serializable {

    @Id
    @Column(name = "SEQ1" , columnDefinition="NUMBER(4)")
    private Long serial;

    @Column(name = "MONTH" , columnDefinition="NUMBER(2)")
    private Integer month;

    @Column(name = "P_CITY_NAME")
    private String cityName;

    @Column(name = "PREV_VALUE" , columnDefinition="NUMBER(6,3)")
    private Double prevValue;

    @Column(name = "P_RUB" , columnDefinition="NUMBER(3,0)")
    private Integer rub;

    @Column(name = "P_DEPT" , columnDefinition="NUMBER(2,0)")
    private Integer dept;

    @Column(name = "P_CITY" , columnDefinition="NUMBER(2,0)")
    private Integer city;

    @Column(name = "P_VALUE" , columnDefinition="NUMBER(8,4)")
    private Double value;

    @Column(name = "P_TOKW" , columnDefinition="NUMBER(9)")
    private Long tokw;

    @Column(name = "P_FROMKW" , columnDefinition="NUMBER(9,0)")
    private Double fromkw;

    @Column(name = "P_TYPE" , columnDefinition="NUMBER(2,0)")
    private Double type;

    @Column(name = "P_DATE")
    private LocalDate date;

    @Column(name = "P_CODE" , columnDefinition="NUMBER(2,0)")
    private Integer code;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(Double prevValue) {
        this.prevValue = prevValue;
    }

    public Integer getRub() {
        return rub;
    }

    public void setRub(Integer rub) {
        this.rub = rub;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Long getTokw() {
        return tokw;
    }

    public void setTokw(Long tokw) {
        this.tokw = tokw;
    }

    public Double getFromkw() {
        return fromkw;
    }

    public void setFromkw(Double fromkw) {
        this.fromkw = fromkw;
    }

    public Double getType() {
        return type;
    }

    public void setType(Double type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
