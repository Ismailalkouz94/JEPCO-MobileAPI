package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "MOB_CUST_SUB_INFO")
public class CustomerSubAccount implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "CUS_SUB_ID" , updatable = false, nullable = false)
//    private Long id;

//    @Column(name = "CUS_SUB_FILE_NUMBER" ,nullable = false ,length = 13)
//    private String fileNumber;

    @EmbeddedId
    protected CustomerSubInfoPK customerSubInfoPK;

    @Column(name = "CUST_SUB_ALIAS")
    private String alias;

    @Column(name = "CUST_SUB_FILE_NO", length = 13)
    private String fileNumber;

    @Column(name = "CUST_SUB_CRE_DT")
    @JsonIgnore
    private LocalDateTime creationDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "CUS_SUB_PRO_ID")
//    @JsonIgnore
//    private CustomerProfile customerProfile;

    @Transient
    @JsonIgnore
    private String mobileNumber;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFileNumber() { return fileNumber; }
//
//    public void setFileNumber(String fileNumber) { this.fileNumber = fileNumber; }


    public CustomerSubInfoPK getCustomerSubInfoPK() { return customerSubInfoPK; }

    public void setCustomerSubInfoPK(CustomerSubInfoPK customerSubInfoPK) { this.customerSubInfoPK = customerSubInfoPK; }

    public String getFileNumber() { return fileNumber; }

    public void setFileNumber(String fileNumber) { this.fileNumber = fileNumber; }

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

//    public CustomerProfile getCustomerProfile() { return customerProfile; }
//
//    public void setCustomerProfile(CustomerProfile customerProfile) { this.customerProfile = customerProfile; }

    @JsonIgnore
    public String getMobileNumber() { return mobileNumber; }

    @JsonProperty
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }
}
