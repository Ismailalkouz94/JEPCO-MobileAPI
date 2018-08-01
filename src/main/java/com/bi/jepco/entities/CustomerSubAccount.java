package com.bi.jepco.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUSTOMER_SUB_ACCOUNT")
public class CustomerSubAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CUS_SUB_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "CUS_SUB_FILE_NUMBER" ,nullable = false ,length = 13)
    private String fileNumber;

    @Column(name = "CUS_SUB_CITY" ,nullable = false ,length = 2)
    private String city;

    @Column(name = "CUS_SUB_ROUND" ,nullable = false ,length = 1)
    private String round;

    @Column(name = "CUS_SUB_DEPT" ,nullable = false ,length = 2)
    private String dept;

    @Column(name = "CUS_SUB_COLL" ,nullable = false ,length = 2)
    private String coll;

    @Column(name = "CUS_SUB_CONS" ,nullable = false ,length = 6)
    private String cons;

    @Column(name = "CUS_SUB_ALIAS")
    private String alias;

    @Column(name = "CUS_SUB_CREATION_DATE")
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUS_SUB_PRO_ID")
    private CustomerProfile customerProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() { return fileNumber; }

    public void setFileNumber(String fileNumber) { this.fileNumber = fileNumber; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getRound() { return round; }

    public void setRound(String round) { this.round = round; }

    public String getDept() { return dept; }

    public void setDept(String dept) { this.dept = dept; }

    public String getColl() { return coll; }

    public void setColl(String coll) { this.coll = coll; }

    public String getCons() { return cons; }

    public void setCons(String cons) { this.cons = cons; }

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
