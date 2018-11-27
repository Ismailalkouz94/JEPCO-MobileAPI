package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MOB_CUST_PNC")
public class CustPNCAccounts {

    @Id
    @GeneratedValue()
    @Column(name = "CUST_PNC_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "CUST_PNC_MOB_NO")
    private CustomerProfile customerProfile;

    @Column(name = "CUST_PNC_TOKEN", updatable = true , length = 300)
    private String token;

    @Column(name = "CUST_PNC_PLATFORM")
    private String platform;

    @Column(name = "CUST_PNC_OS_VER")
    private String osVersion;

    @Transient
    @JsonIgnore
    private String mobileNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String tocken) {
        this.token = tocken;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @JsonIgnore
    public String getMobileNumber() {
        return mobileNumber;
    }

    @JsonProperty
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustPNCAccounts that = (CustPNCAccounts) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(customerProfile, that.customerProfile) &&
                Objects.equals(token, that.token) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(osVersion, that.osVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerProfile, token, platform, osVersion);
    }
}
