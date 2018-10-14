
package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CustomerSubInfoPK implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUST_MOB_NO")
    @JsonIgnore
    private CustomerProfile customerProfile;

    @Column(name = "CUST_SUB_CITY_NO" ,nullable = false ,length = 2 , columnDefinition="NUMBER(2)")
    private Integer city;

    @Column(name = "CUST_SUB_ROUND_NO" ,nullable = false ,length = 1 , columnDefinition="NUMBER(1)")
    private Integer round;

    @Column(name = "CUST_SUB_DEPT_NO" ,nullable = false ,length = 2 , columnDefinition="NUMBER(2)")
    private Integer dept;

    @Column(name = "CUST_SUB_COLL_NO" ,nullable = false ,length = 2 , columnDefinition="NUMBER(2)")
    private Integer coll;

    @Column(name = "CUST_SUB_CONS_NO" ,nullable = false ,length = 6 , columnDefinition="NUMBER(6)")
    private Integer cons;

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }


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
}
