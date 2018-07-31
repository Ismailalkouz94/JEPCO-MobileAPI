package com.bi.jepco.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "CUSTOMER_PROFILE")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CUS_PRO_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "CUS_PRO_NATIONAL_NUMBER")
    private String nationalNumber;

    @Column(name = "CUS_PRO_FIRST_NAME")
    private String firstName;

    @Column(name = "CUS_PRO_LAST_NAME")
    private String lastName;

    @Column(name = "CUS_PRO_MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "CUS_PRO_STATUS")
    private Integer status;

    @Column(name = "CUS_PRO_CREATION_DATE")
    private LocalDateTime creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
