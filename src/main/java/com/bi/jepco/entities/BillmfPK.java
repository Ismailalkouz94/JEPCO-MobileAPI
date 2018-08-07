/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jepco.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author LENOVO
 */
@Embeddable
public class BillmfPK implements Serializable{

    @Column(name = "M_CITY_NO")
    private Integer mCityNo;

    @Column(name = "M_ROUND_NO")
    private Integer mRoundNo;

    @Column(name = "M_DEPT_NO")
    private Integer mDeptNo;

    @Column(name = "M_COLL_NO")
    private Integer mCollNo;

    @Column(name = "M_CONS_NO")
    private Integer mConsNo;

    public Integer getMCityNo() {
        return mCityNo;
    }

    public void setMCityNo(Integer mCityNo) {
        this.mCityNo = mCityNo;
    }

    public Integer getMRoundNo() {
        return mRoundNo;
    }

    public void setMRoundNo(Integer mRoundNo) {
        this.mRoundNo = mRoundNo;
    }

    public Integer getMDeptNo() {
        return mDeptNo;
    }

    public void setMDeptNo(Integer mDeptNo) {
        this.mDeptNo = mDeptNo;
    }

    public Integer getMCollNo() {
        return mCollNo;
    }

    public void setMCollNo(Integer mCollNo) {
        this.mCollNo = mCollNo;
    }

    public Integer getMConsNo() {
        return mConsNo;
    }

    public void setMConsNo(Integer mConsNo) {
        this.mConsNo = mConsNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mCityNo;
        hash += (int) mRoundNo;
        hash += (int) mDeptNo;
        hash += (int) mCollNo;
        hash += (int) mConsNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BillmfPK)) {
            return false;
        }
        BillmfPK other = (BillmfPK) object;
        if (this.mCityNo != other.mCityNo) {
            return false;
        }
        if (this.mRoundNo != other.mRoundNo) {
            return false;
        }
        if (this.mDeptNo != other.mDeptNo) {
            return false;
        }
        if (this.mCollNo != other.mCollNo) {
            return false;
        }
        if (this.mConsNo != other.mConsNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BillmfPK[ mCityNo=" + mCityNo + ", mRoundNo=" + mRoundNo + ", mDeptNo=" + mDeptNo + ", mCollNo=" + mCollNo + ", mConsNo=" + mConsNo + " ]";
    }
    
}
