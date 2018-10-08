package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOB_SMS_INFO")
public class SmsVerification implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "SMS_VER_ID" , updatable = false, nullable = false)
//    private Long id;

    @Column(name = "SMS_CODE" ,nullable = false ,length = 4)
    private String code;

    @Id
    @Column(name = "SMS_MOB_NO" ,nullable = false ,length = 14)
    private String mobileNumber;

    @Column(name = "SMS_STATUS" ,length = 1)
    private Integer status;

    @Column(name = "SMS_CRE_DT")
    @JsonIgnore
    private LocalDateTime creationDate;

    @Column(name = "SMS_EXP_DT")
    @JsonIgnore
    private LocalDateTime expirationDate;

    @Column(name = "SMS_USED_DT")
    @JsonIgnore
    private LocalDateTime usedDate;

    @Transient
    @JsonIgnore
    private String fileNumber;

    @Transient
    @JsonIgnore
    private Integer idType;

    @Transient
    @JsonIgnore
    private String nationalNumber;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    @JsonIgnore
    public Integer getIdType() {
        return idType;
    }

    @JsonProperty
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getUsedDate() { return usedDate; }

    public void setUsedDate(LocalDateTime usedDate) { this.usedDate = usedDate; }

    @JsonIgnore
    public String getFileNumber() { return fileNumber; }

    @JsonProperty
    public void setFileNumber(String fileNumber) { this.fileNumber = fileNumber; }

    @JsonIgnore
    public String getNationalNumber() {
        return nationalNumber;
    }

    @JsonProperty
    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mobileNumber != null ? mobileNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SmsVerification)) {
            return false;
        }
        SmsVerification other = (SmsVerification) object;
        if ((this.mobileNumber == null && other.mobileNumber != null) || (this.mobileNumber != null && !this.mobileNumber.equals(other.mobileNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SMS_VERIFICATION[ id=" + mobileNumber + " ]";
    }
}
