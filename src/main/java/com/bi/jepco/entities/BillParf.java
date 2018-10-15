package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TARIFFA")
public class BillParf implements Serializable {

    @Id
    @Column(name = "P_VALUE")
    private Double pValue;

    @Column(name = "PREV_VALUE")
    private Double prevValue;

    @Column(name = "P_TOKW")
    private Double tokw;

    @Column(name = "P_FROMKW")
    private Double fromkw;

    @Column(name = "P_TYPE")
    private Integer pType;


    @JsonIgnore
    @Column(name = "P_DATE")
    private LocalDate pDate;

    @Column(name = "TYPE_DESC")
    private String typeDesc;

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Double getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(Double prevValue) {
        this.prevValue = prevValue;
    }

    public Double getTokw() {
        return tokw;
    }

    public void setTokw(Double tokw) {
        this.tokw = tokw;
    }

    public Double getFromkw() {
        return fromkw;
    }

    public void setFromkw(Double fromkw) {
        this.fromkw = fromkw;
    }

    public Double getpValue() {
        return pValue;
    }

    public void setpValue(Double pValue) {
        this.pValue = pValue;
    }


    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }

    public LocalDate getpDate() {
        return pDate;
    }

    public void setpDate(LocalDate pDate) {
        this.pDate = pDate;
    }
}
