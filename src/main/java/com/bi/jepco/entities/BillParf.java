package com.bi.jepco.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class BillParf implements Serializable {

    private Double prevValue;

    private Double pValue;

    private Double tokw;

    private Double fromkw;

    private Integer pType;

    private LocalDate pDate;

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
