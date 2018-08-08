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
    private String arabicText;

    @Column(name = "T_TXT_ENG")
    private String englishText;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public String getArabicText() {
        return arabicText;
    }

    public void setArabicText(String arabicText) {
        this.arabicText = arabicText;
    }

    public String getEnglishText() {
        return englishText;
    }

    public void setEnglishText(String englishText) {
        this.englishText = englishText;
    }
}
