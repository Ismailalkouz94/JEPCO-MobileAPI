package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_SUB_ACCOUNT")
public class CustomerSubAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CUS_SUB_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "CUS_SUB_FILE_NUMBER" ,nullable = false ,length = 13)
    private String fileNumber;

    @Column(name = "CUS_SUB_CITY" ,nullable = false ,length = 2 , columnDefinition="NUMBER(2)")
    private Integer city;

    @Column(name = "CUS_SUB_ROUND" ,nullable = false ,length = 1 , columnDefinition="NUMBER(1)")
    private Integer round;

    @Column(name = "CUS_SUB_DEPT" ,nullable = false ,length = 2 , columnDefinition="NUMBER(2)")
    private Integer dept;

    @Column(name = "CUS_SUB_COLL" ,nullable = false ,length = 2 , columnDefinition="NUMBER(2)")
    private Integer coll;

    @Column(name = "CUS_SUB_CONS" ,nullable = false ,length = 6 , columnDefinition="NUMBER(6)")
    private Integer cons;

    @Column(name = "CUS_SUB_ALIAS")
    private String alias;

    @Column(name = "CUS_SUB_CREATION_DATE")
    @JsonIgnore
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUS_SUB_PRO_ID")
    @JsonIgnore
    private CustomerProfile customerProfile;

    @Transient
    @JsonIgnore
    private String nationalNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() { return fileNumber; }

    public void setFileNumber(String fileNumber) { this.fileNumber = fileNumber; }

    public Integer getCity() { return city; }

    public void setCity(Integer city) { this.city = city; }

    public Integer getRound() { return round; }

    public void setRound(Integer round) { this.round = round; }

    public Integer getDept() { return dept; }

    public void setDept(Integer dept) { this.dept = dept; }

    public Integer getColl() { return coll; }

    public void setColl(Integer coll) { this.coll = coll; }

    public Integer getCons() { return cons; }

    public void setCons(Integer cons) { this.cons = cons; }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public CustomerProfile getCustomerProfile() { return customerProfile; }

    public void setCustomerProfile(CustomerProfile customerProfile) { this.customerProfile = customerProfile; }

    @JsonIgnore
    public String getNationalNumber() { return nationalNumber; }

    @JsonProperty
    public void setNationalNumber(String nationalNumber) { this.nationalNumber = nationalNumber; }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CustomerSubAccount)) {
            return false;
        }
        CustomerSubAccount other = (CustomerSubAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerSubAccount[ id=" + id + " ]";
    }
}
