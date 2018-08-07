package com.bi.jepco.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MOB_TIPS")
public class MobileTips implements Serializable {

    @Id
    @Column(name = "T_SER" , columnDefinition="NUMBER(2)")
    private Long serial;

    @Column(name = "T_TXT")
    private String text;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
