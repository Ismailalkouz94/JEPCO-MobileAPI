package com.bi.jepco.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "CUSTOMER_SUB_ACCOUNT")
public class CustomerSubAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CUS_SUB_ID" , updatable = false, nullable = false)
    private Long id;

    @Column(name = "CUS_SUB_FILE_NUMBER")
    private String fileNumber;

    @Column(name = "CUS_SUB_ALIAS")
    private String alias;

    @Column(name = "CUS_SUB_CREATION_DATE")
    private LocalDateTime creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

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
