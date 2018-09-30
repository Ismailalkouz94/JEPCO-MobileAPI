package com.bi.jepco.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "MOB_GPS_INFO")
public class PaymentCenter implements Serializable {

    @Id
    @Column(name = "GPS_OFFICE")
    private Long id;

//    @Column(name = "PAY_CEN_NAME")
//    private String name;

//    @Column(name = "GPS_ADDRESS")
//    private String address;

    @Column(name = "GPS_LAT")
    private Double longitude;

    @Column(name = "GPS_LONG")
    private Double latitude;

//    @Column(name = "GPS_PHONE_NUMBER")
//    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
}
