package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_PROFILE")
public class CustomerProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CUS_PRO_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "CUS_PRO_NATIONAL_NUMBER" ,nullable = false ,unique = true ,length = 10)
    private String nationalNumber;

    @Column(name = "CUS_PRO_FIRST_NAME" ,nullable = false ,length = 30)
    private String firstName;

    @Column(name = "CUS_PRO_LAST_NAME" ,nullable = false ,length = 30)
    private String lastName;

    @Column(name = "CUS_PRO_MOBILE_NUMBER" ,nullable = false ,length = 14)
    private String mobileNumber;

    @Column(name = "CUS_PRO_STATUS" , length = 1)
    private Integer status;

    @Column(name = "CUS_PRO_CREATION_DATE")
    @JsonIgnore
    private LocalDateTime creationDate;

    @Transient
    @JsonIgnore
    private String code;

    @Transient
    @JsonIgnore
    private String fileNumber;

    @Transient
    private List<CustomerSubAccount> customerSubAccountList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @JsonIgnore
    public String getCode() { return code; }

    @JsonProperty
    public void setCode(String code) { this.code = code; }

    @JsonIgnore
    public String getFileNumber() { return fileNumber; }

    @JsonProperty
    public void setFileNumber(String fileNumber) { this.fileNumber = fileNumber; }

    public List<CustomerSubAccount> getCustomerSubAccountList() { return customerSubAccountList; }

    public void setCustomerSubAccountList(List<CustomerSubAccount> customerSubAccountList) { this.customerSubAccountList = customerSubAccountList; }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CustomerProfile)) {
            return false;
        }
        CustomerProfile other = (CustomerProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerProfile[ id=" + id + " ]";
    }
}
