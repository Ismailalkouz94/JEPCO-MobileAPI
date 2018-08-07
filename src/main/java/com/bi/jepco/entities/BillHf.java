package com.bi.jepco.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "BILLHF")
public class BillHf implements Serializable {

    @Column(name = "H_CITY_NO" , columnDefinition="NUMBER(2)")
    private Integer city;

    @Column(name = "H_ROUND_NO" , columnDefinition="NUMBER(1)")
    private Integer round;

    @Column(name = "H_DEPT_NO" , columnDefinition="NUMBER(2)")
    private Integer dept;

    @Column(name = "H_COLL_NO" , columnDefinition="NUMBER(2)")
    private Integer coll;

    @Column(name = "H_CONS_NO" , columnDefinition="NUMBER(6)")
    private Integer cons;

    @Id
    @Column(name = "H_BIL_NO" , columnDefinition="NUMBER(8)")
    private Long billNo;

    @Column(name = "H_CITY_NO_AL" , columnDefinition="NUMBER(2)")
    private Integer cityAl;

    @Column(name = "H_ROUND_NO_AL" , columnDefinition="NUMBER(1)")
    private Integer roundAL;

    @Column(name = "H_SUB_R_NO_AL" , columnDefinition="NUMBER(1)")
    private Integer subNoAl;

    @Column(name = "H_DEPT_NO_AL" , columnDefinition="NUMBER(2)")
    private Integer deptAl;

    @Column(name = "H_COLL_NO_AL" , columnDefinition="NUMBER(2)")
    private Integer collAl;

    @Column(name = "H_CONS_NO_AL" , columnDefinition="NUMBER(6)")
    private Integer consAl;

    @Column(name = "H_TRANS_DATE" )
    private LocalDate transDate;

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getColl() {
        return coll;
    }

    public void setColl(Integer coll) {
        this.coll = coll;
    }

    public Integer getCons() {
        return cons;
    }

    public void setCons(Integer cons) {
        this.cons = cons;
    }

    public Long getBillNo() {
        return billNo;
    }

    public void setBillNo(Long billNo) {
        this.billNo = billNo;
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
}
