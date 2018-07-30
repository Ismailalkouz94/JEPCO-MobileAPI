package com.bi.jepco.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "SMS_VERIFICATION")
public class SmsVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SMS_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "SMS_CODE")
    private String code;

    @Column(name = "SMS_MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "SMS_STATUS")
    private Integer status;

    @Column(name = "SMS_CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "SMS_EXPIRATION_DATE")
    private LocalDateTime expirationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SmsVerification)) {
            return false;
        }
        SmsVerification other = (SmsVerification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SMS_VERIFICATION[ id=" + id + " ]";
    }
}
