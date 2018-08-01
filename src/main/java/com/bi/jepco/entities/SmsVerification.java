package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SMS_VERIFICATION")
public class SmsVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "SMS_VER_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "SMS_VER_CODE" ,nullable = false ,length = 4)
    private String code;

    @Column(name = "SMS_VER_MOBILE_NUMBER" ,nullable = false ,length = 14)
    private String mobileNumber;

    @Column(name = "SMS_VER_STATUS" ,length = 1)
    private Integer status;

    @Column(name = "SMS_VER_CREATION_DATE")
    @JsonIgnore
    private LocalDateTime creationDate;

    @Column(name = "SMS_VER_EXPIRATION_DATE")
    @JsonIgnore
    private LocalDateTime expirationDate;

    @Column(name = "SMS_VER_USED_DATE")
    @JsonIgnore
    private LocalDateTime usedDate;

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

    public LocalDateTime getUsedDate() { return usedDate; }

    public void setUsedDate(LocalDateTime usedDate) { this.usedDate = usedDate; }

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
