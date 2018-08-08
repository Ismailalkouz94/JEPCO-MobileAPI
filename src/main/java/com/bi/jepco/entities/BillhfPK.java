
package com.bi.jepco.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class BillhfPK implements Serializable{

    @Column(name = "H_CITY_NO")
    private Integer hCityNo;

    @Column(name = "H_ROUND_NO")
    private Integer hRoundNo;

    @Column(name = "H_DEPT_NO")
    private Integer hDeptNo;

    @Column(name = "H_COLL_NO")
    private Integer hCollNo;

    @Column(name = "H_CONS_NO")
    private Integer hConsNo;

    @Column(name = "H_BIL_NO")
    private Long hBillNo;

    public Integer gethCityNo() {
        return hCityNo;
    }

    public void sethCityNo(Integer hCityNo) {
        this.hCityNo = hCityNo;
    }

    public Integer gethRoundNo() {
        return hRoundNo;
    }

    public void sethRoundNo(Integer hRoundNo) {
        this.hRoundNo = hRoundNo;
    }

    public Integer gethDeptNo() {
        return hDeptNo;
    }

    public void sethDeptNo(Integer hDeptNo) {
        this.hDeptNo = hDeptNo;
    }

    public Integer gethCollNo() {
        return hCollNo;
    }

    public void sethCollNo(Integer hCollNo) {
        this.hCollNo = hCollNo;
    }

    public Integer gethConsNo() {
        return hConsNo;
    }

    public void sethConsNo(Integer hConsNo) {
        this.hConsNo = hConsNo;
    }

    public Long gethBillNo() {
        return hBillNo;
    }

    public void sethBillNo(Long hBillNo) {
        this.hBillNo = hBillNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) hCityNo;
        hash += (int) hRoundNo;
        hash += (int) hDeptNo;
        hash += (int) hCollNo;
        hash += (int) hConsNo;
        hash += (long) hBillNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BillhfPK)) {
            return false;
        }
        BillhfPK other = (BillhfPK) object;
        if (this.hCityNo != other.hCityNo) {
            return false;
        }
        if (this.hRoundNo != other.hRoundNo) {
            return false;
        }
        if (this.hDeptNo != other.hDeptNo) {
            return false;
        }
        if (this.hCollNo != other.hCollNo) {
            return false;
        }
        if (this.hConsNo != other.hConsNo) {
            return false;
        }
        if (this.hBillNo != other.hBillNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BillhfPK[ hCityNo=" + hCityNo + ", hRoundNo=" + hRoundNo + ", hDeptNo=" + hDeptNo + ", hCollNo=" + hCollNo + ", hConsNo=" + hConsNo + " ]";
    }
    
}
