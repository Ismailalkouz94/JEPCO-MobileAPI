package com.bi.jepco.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MOB_GPS_INFO")
public class PaymentCenter implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GPS_OFFICE")
    private HostName hostName;

    @Column(name = "GPS_LAT")
    private Double longitude;

    @Column(name = "GPS_LONG")
    private Double latitude;

    public HostName getHostName() {
        return hostName;
    }

    public void setHostName(HostName hostName) {
        this.hostName = hostName;
    }

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
}
