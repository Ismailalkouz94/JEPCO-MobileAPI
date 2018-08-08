package com.bi.jepco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "BILLMF")
public class Billmf implements Serializable {

    @EmbeddedId
    @JsonIgnore
    protected BillmfPK billmfPK;

    @JsonIgnore
    @Column(name = "M_CITY_NO_AL")
    private Integer mCityNoAl;

    @JsonIgnore
    @Column(name = "M_ROUND_NO_AL")
    private Integer mRoundNoAl;

    @JsonIgnore
    @Column(name = "M_SUB_R_NO_AL")
    private Integer mSubRNoAl;

    @JsonIgnore
    @Column(name = "M_DEPT_NO_AL")
    private Integer mDeptNoAl;

    @JsonIgnore
    @Column(name = "M_COLL_NO_AL")
    private Integer mCollNoAl;

    @JsonIgnore
    @Column(name = "M_CONS_NO_AL")
    private Integer mConsNoAl;

    @Column(name = "M_CONSUMER_NAME")
    private String mConsumerName;

    @JsonIgnore
    @Column(name = "CONS_NAME_4")
    private String consName4;

    @Column(name = "M_OWNER_NAME")
    private String mOwnerName;

    @JsonIgnore
    @Column(name = "M_CONS_TYPE")
    private Integer mConsType;

    @Column(name = "M_CONS_DATE")
    @JsonIgnore
    private LocalDateTime mConsDate;

    @Column(name = "M_METER_NO")
    private Long mMeterNo;

    @JsonIgnore
    @Column(name = "M_INSURANCE_VAL")
    private BigDecimal mInsuranceVal;

    @JsonIgnore
    @Column(name = "M_FAZ")
    private Integer mFaz;

    @JsonIgnore
    @Column(name = "M_AMBER_MAX")
    private Integer mAmberMax;

    @JsonIgnore
    @Column(name = "M_AMBER_MIN")
    private Integer mAmberMin;

    @JsonIgnore
    @Column(name = "M_FAC_PRD")
    private BigDecimal mFacPrd;

    @JsonIgnore
    @Column(name = "M_DISCOUNT")
    private Integer mDiscount;

    @JsonIgnore
    @Column(name = "ADD_TAX")
    private Integer addTax;

    @JsonIgnore
    @Column(name = "FILS_TAX")
    private Integer filsTax;

    @JsonIgnore
    @Column(name = "TELIVISION_TAX")
    private Integer telivisionTax;

    @JsonIgnore
    @Column(name = "GAR_CITY")
    private Integer garCity;

    @JsonIgnore
    @Column(name = "GARBIGE_TAX")
    private Integer garbigeTax;

    @JsonIgnore
    @Column(name = "GAR_DEPT")
    private Integer garDept;

    @JsonIgnore
    @Column(name = "M_COPY_NO")
    private Integer mCopyNo;

    @JsonIgnore
    @Column(name = "M_GROUP_NO")
    private Integer mGroupNo;

    @JsonIgnore
    @Column(name = "M_EMPLOYEE_NO")
    private Integer mEmployeeNo;

    @JsonIgnore
    @Column(name = "M_METER_STATUS")
    private Integer mMeterStatus;

    @JsonIgnore
    @Column(name = "M_PREVIOUS_READ")
    private Integer mPreviousRead;

    @Column(name = "M_PREV_READ_DATE")
    @JsonIgnore
    private LocalDateTime mPrevReadDate;

    @JsonIgnore
    @Column(name = "M_TOTAL_CONSUM_QTY")
    private Integer mTotalConsumQty;

    @JsonIgnore
    @Column(name = "M_TOTAL_CONSUM_VALUE")
    private BigDecimal mTotalConsumValue;

    @JsonIgnore
    @Column(name = "M_TOTAL_BILL_NO")
    private Integer mTotalBillNo;

    @JsonIgnore
    @Column(name = "M_CON_BALANCE")
    private BigDecimal mConBalance;

    @JsonIgnore
    @Column(name = "M_ESTIMATE_READ")
    private Integer mEstimateRead;

    @Column(name = "M_ESTIMATE_READ_DATE")
    @JsonIgnore
    private LocalDateTime mEstimateReadDate;

    @JsonIgnore
    @Column(name = "M_ESTIMATE_CONSUM")
    private Integer mEstimateConsum;

    @Column(name = "M_LAST_PAID_DATE")
    @JsonIgnore
    private LocalDateTime mLastPaidDate;

    @JsonIgnore
    @Column(name = "M_MAX_READ")
    private Integer mMaxRead;

    @Column(name = "M_LAST_MOD_DATE")
    @JsonIgnore
    private LocalDateTime mLastModDate;

    @JsonIgnore
    @Column(name = "M_LOSES_POWER")
    private Integer mLosesPower;

    @JsonIgnore
    @Column(name = "M_SER_NO")
    private Integer mSerNo;

    @JsonIgnore
    @Column(name = "M_MAN_DATE")
    private Integer mManDate;

    @JsonIgnore
    @Column(name = "M_MAN_CODE")
    private Integer mManCode;

    @JsonIgnore
    @Column(name = "M_MAN_TYPE")
    private Integer mManType;

    @JsonIgnore
    @Column(name = "M_APAY_BAL")
    private BigDecimal mApayBal;

    @JsonIgnore
    @Column(name = "M_FAC_M")
    private BigDecimal mFacM;

    @JsonIgnore
    @Column(name = "M_MAX_CT")
    private Integer mMaxCt;

    @JsonIgnore
    @Column(name = "M_PTYPE")
    private Integer mPtype;

    @JsonIgnore
    @Column(name = "M_GROUP_GVMA")
    private Integer mGroupGvma;

    @JsonIgnore
    @Column(name = "M_GROUP_GVMI")
    private Integer mGroupGvmi;

    @JsonIgnore
    @Column(name = "M_GROUP_GVTY")
    private Integer mGroupGvty;

    @JsonIgnore
    @Column(name = "M_GROUP_GVCI")
    private Integer mGroupGvci;

    @JsonIgnore
    @Column(name = "M_CNT_UP")
    private Integer mCntUp;

    @JsonIgnore
    @Column(name = "M_CNT_UNUP")
    private Integer mCntUnup;

    @JsonIgnore
    @Column(name = "M_INTEREST")
    private Integer mInterest;

    @JsonIgnore
    @Column(name = "M_CODE_GV")
    private Integer mCodeGv;

    @JsonIgnore
    @Column(name = "M_CATEGORY")
    private Integer mCategory;

    @JsonIgnore
    @Column(name = "M_ORGF")
    private Integer mOrgf;

    @JsonIgnore
    @Column(name = "M_NATIO_NO")
    private Long mNatioNo;

    @JsonIgnore
    @Column(name = "M_TEL_NO")
    private Long mTelNo;

    @JsonIgnore
    @Column(name = "M_METER_RATE")
    private Integer mMeterRate;

    @JsonIgnore
    @Column(name = "M_METER_BREAKER")
    private Integer mMeterBreaker;

    @JsonIgnore
    @Column(name = "M_INTERNAL_METER_NO")
    private String mInternalMeterNo;

    @Transient
    @JsonIgnore
    private List<Billhf> bills;

    public BillmfPK getBillmfPK() {
        return billmfPK;
    }

    public void setBillmfPK(BillmfPK billmfPK) {
        this.billmfPK = billmfPK;
    }

    public Integer getmCityNoAl() {
        return mCityNoAl;
    }

    public void setmCityNoAl(Integer mCityNoAl) {
        this.mCityNoAl = mCityNoAl;
    }

    public Integer getmRoundNoAl() {
        return mRoundNoAl;
    }

    public void setmRoundNoAl(Integer mRoundNoAl) {
        this.mRoundNoAl = mRoundNoAl;
    }

    public Integer getmSubRNoAl() {
        return mSubRNoAl;
    }

    public void setmSubRNoAl(Integer mSubRNoAl) {
        this.mSubRNoAl = mSubRNoAl;
    }

    public Integer getmDeptNoAl() {
        return mDeptNoAl;
    }

    public void setmDeptNoAl(Integer mDeptNoAl) {
        this.mDeptNoAl = mDeptNoAl;
    }

    public Integer getmCollNoAl() {
        return mCollNoAl;
    }

    public void setmCollNoAl(Integer mCollNoAl) {
        this.mCollNoAl = mCollNoAl;
    }

    public Integer getmConsNoAl() {
        return mConsNoAl;
    }

    public void setmConsNoAl(Integer mConsNoAl) {
        this.mConsNoAl = mConsNoAl;
    }

    public String getmConsumerName() {
        return mConsumerName;
    }

    public void setmConsumerName(String mConsumerName) {
        this.mConsumerName = mConsumerName;
    }

    public String getConsName4() {
        return consName4;
    }

    public void setConsName4(String consName4) {
        this.consName4 = consName4;
    }

    public String getmOwnerName() {
        return mOwnerName;
    }

    public void setmOwnerName(String mOwnerName) {
        this.mOwnerName = mOwnerName;
    }

    public Integer getmConsType() {
        return mConsType;
    }

    public void setmConsType(Integer mConsType) {
        this.mConsType = mConsType;
    }

    public LocalDateTime getmConsDate() {
        return mConsDate;
    }

    public void setmConsDate(LocalDateTime mConsDate) {
        this.mConsDate = mConsDate;
    }

    public Long getmMeterNo() {
        return mMeterNo;
    }

    public void setmMeterNo(Long mMeterNo) {
        this.mMeterNo = mMeterNo;
    }

    public BigDecimal getmInsuranceVal() {
        return mInsuranceVal;
    }

    public void setmInsuranceVal(BigDecimal mInsuranceVal) {
        this.mInsuranceVal = mInsuranceVal;
    }

    public Integer getmFaz() {
        return mFaz;
    }

    public void setmFaz(Integer mFaz) {
        this.mFaz = mFaz;
    }

    public Integer getmAmberMax() {
        return mAmberMax;
    }

    public void setmAmberMax(Integer mAmberMax) {
        this.mAmberMax = mAmberMax;
    }

    public Integer getmAmberMin() {
        return mAmberMin;
    }

    public void setmAmberMin(Integer mAmberMin) {
        this.mAmberMin = mAmberMin;
    }

    public BigDecimal getmFacPrd() {
        return mFacPrd;
    }

    public void setmFacPrd(BigDecimal mFacPrd) {
        this.mFacPrd = mFacPrd;
    }

    public Integer getmDiscount() {
        return mDiscount;
    }

    public void setmDiscount(Integer mDiscount) {
        this.mDiscount = mDiscount;
    }

    public Integer getAddTax() {
        return addTax;
    }

    public void setAddTax(Integer addTax) {
        this.addTax = addTax;
    }

    public Integer getFilsTax() {
        return filsTax;
    }

    public void setFilsTax(Integer filsTax) {
        this.filsTax = filsTax;
    }

    public Integer getTelivisionTax() {
        return telivisionTax;
    }

    public void setTelivisionTax(Integer telivisionTax) {
        this.telivisionTax = telivisionTax;
    }

    public Integer getGarCity() {
        return garCity;
    }

    public void setGarCity(Integer garCity) {
        this.garCity = garCity;
    }

    public Integer getGarbigeTax() {
        return garbigeTax;
    }

    public void setGarbigeTax(Integer garbigeTax) {
        this.garbigeTax = garbigeTax;
    }

    public Integer getGarDept() {
        return garDept;
    }

    public void setGarDept(Integer garDept) {
        this.garDept = garDept;
    }

    public Integer getmCopyNo() {
        return mCopyNo;
    }

    public void setmCopyNo(Integer mCopyNo) {
        this.mCopyNo = mCopyNo;
    }

    public Integer getmGroupNo() {
        return mGroupNo;
    }

    public void setmGroupNo(Integer mGroupNo) {
        this.mGroupNo = mGroupNo;
    }

    public Integer getmEmployeeNo() {
        return mEmployeeNo;
    }

    public void setmEmployeeNo(Integer mEmployeeNo) {
        this.mEmployeeNo = mEmployeeNo;
    }

    public Integer getmMeterStatus() {
        return mMeterStatus;
    }

    public void setmMeterStatus(Integer mMeterStatus) {
        this.mMeterStatus = mMeterStatus;
    }

    public Integer getmPreviousRead() {
        return mPreviousRead;
    }

    public void setmPreviousRead(Integer mPreviousRead) {
        this.mPreviousRead = mPreviousRead;
    }

    public LocalDateTime getmPrevReadDate() {
        return mPrevReadDate;
    }

    public void setmPrevReadDate(LocalDateTime mPrevReadDate) {
        this.mPrevReadDate = mPrevReadDate;
    }

    public Integer getmTotalConsumQty() {
        return mTotalConsumQty;
    }

    public void setmTotalConsumQty(Integer mTotalConsumQty) {
        this.mTotalConsumQty = mTotalConsumQty;
    }

    public BigDecimal getmTotalConsumValue() {
        return mTotalConsumValue;
    }

    public void setmTotalConsumValue(BigDecimal mTotalConsumValue) {
        this.mTotalConsumValue = mTotalConsumValue;
    }

    public Integer getmTotalBillNo() {
        return mTotalBillNo;
    }

    public void setmTotalBillNo(Integer mTotalBillNo) {
        this.mTotalBillNo = mTotalBillNo;
    }

    public BigDecimal getmConBalance() {
        return mConBalance;
    }

    public void setmConBalance(BigDecimal mConBalance) {
        this.mConBalance = mConBalance;
    }

    public Integer getmEstimateRead() {
        return mEstimateRead;
    }

    public void setmEstimateRead(Integer mEstimateRead) {
        this.mEstimateRead = mEstimateRead;
    }

    public LocalDateTime getmEstimateReadDate() {
        return mEstimateReadDate;
    }

    public void setmEstimateReadDate(LocalDateTime mEstimateReadDate) {
        this.mEstimateReadDate = mEstimateReadDate;
    }

    public Integer getmEstimateConsum() {
        return mEstimateConsum;
    }

    public void setmEstimateConsum(Integer mEstimateConsum) {
        this.mEstimateConsum = mEstimateConsum;
    }

    public LocalDateTime getmLastPaidDate() {
        return mLastPaidDate;
    }

    public void setmLastPaidDate(LocalDateTime mLastPaidDate) {
        this.mLastPaidDate = mLastPaidDate;
    }

    public Integer getmMaxRead() {
        return mMaxRead;
    }

    public void setmMaxRead(Integer mMaxRead) {
        this.mMaxRead = mMaxRead;
    }

    public LocalDateTime getmLastModDate() {
        return mLastModDate;
    }

    public void setmLastModDate(LocalDateTime mLastModDate) {
        this.mLastModDate = mLastModDate;
    }

    public Integer getmLosesPower() {
        return mLosesPower;
    }

    public void setmLosesPower(Integer mLosesPower) {
        this.mLosesPower = mLosesPower;
    }

    public Integer getmSerNo() {
        return mSerNo;
    }

    public void setmSerNo(Integer mSerNo) {
        this.mSerNo = mSerNo;
    }

    public Integer getmManDate() {
        return mManDate;
    }

    public void setmManDate(Integer mManDate) {
        this.mManDate = mManDate;
    }

    public Integer getmManCode() {
        return mManCode;
    }

    public void setmManCode(Integer mManCode) {
        this.mManCode = mManCode;
    }

    public Integer getmManType() {
        return mManType;
    }

    public void setmManType(Integer mManType) {
        this.mManType = mManType;
    }

    public BigDecimal getmApayBal() {
        return mApayBal;
    }

    public void setmApayBal(BigDecimal mApayBal) {
        this.mApayBal = mApayBal;
    }

    public BigDecimal getmFacM() {
        return mFacM;
    }

    public void setmFacM(BigDecimal mFacM) {
        this.mFacM = mFacM;
    }

    public Integer getmMaxCt() {
        return mMaxCt;
    }

    public void setmMaxCt(Integer mMaxCt) {
        this.mMaxCt = mMaxCt;
    }

    public Integer getmPtype() {
        return mPtype;
    }

    public void setmPtype(Integer mPtype) {
        this.mPtype = mPtype;
    }

    public Integer getmGroupGvma() {
        return mGroupGvma;
    }

    public void setmGroupGvma(Integer mGroupGvma) {
        this.mGroupGvma = mGroupGvma;
    }

    public Integer getmGroupGvmi() {
        return mGroupGvmi;
    }

    public void setmGroupGvmi(Integer mGroupGvmi) {
        this.mGroupGvmi = mGroupGvmi;
    }

    public Integer getmGroupGvty() {
        return mGroupGvty;
    }

    public void setmGroupGvty(Integer mGroupGvty) {
        this.mGroupGvty = mGroupGvty;
    }

    public Integer getmGroupGvci() {
        return mGroupGvci;
    }

    public void setmGroupGvci(Integer mGroupGvci) {
        this.mGroupGvci = mGroupGvci;
    }

    public Integer getmCntUp() {
        return mCntUp;
    }

    public void setmCntUp(Integer mCntUp) {
        this.mCntUp = mCntUp;
    }

    public Integer getmCntUnup() {
        return mCntUnup;
    }

    public void setmCntUnup(Integer mCntUnup) {
        this.mCntUnup = mCntUnup;
    }

    public Integer getmInterest() {
        return mInterest;
    }

    public void setmInterest(Integer mInterest) {
        this.mInterest = mInterest;
    }

    public Integer getmCodeGv() {
        return mCodeGv;
    }

    public void setmCodeGv(Integer mCodeGv) {
        this.mCodeGv = mCodeGv;
    }

    public Integer getmCategory() {
        return mCategory;
    }

    public void setmCategory(Integer mCategory) {
        this.mCategory = mCategory;
    }

    public Integer getmOrgf() {
        return mOrgf;
    }

    public void setmOrgf(Integer mOrgf) {
        this.mOrgf = mOrgf;
    }

    public Long getmNatioNo() {
        return mNatioNo;
    }

    public void setmNatioNo(Long mNatioNo) {
        this.mNatioNo = mNatioNo;
    }

    public Long getmTelNo() {
        return mTelNo;
    }

    public void setmTelNo(Long mTelNo) {
        this.mTelNo = mTelNo;
    }

    public Integer getmMeterRate() {
        return mMeterRate;
    }

    public void setmMeterRate(Integer mMeterRate) {
        this.mMeterRate = mMeterRate;
    }

    public Integer getmMeterBreaker() {
        return mMeterBreaker;
    }

    public void setmMeterBreaker(Integer mMeterBreaker) {
        this.mMeterBreaker = mMeterBreaker;
    }

    public String getmInternalMeterNo() {
        return mInternalMeterNo;
    }

    public void setmInternalMeterNo(String mInternalMeterNo) {
        this.mInternalMeterNo = mInternalMeterNo;
    }

    @JsonProperty
    public List<Billhf> getBills() {
        return bills;
    }

    @JsonIgnore
    public void setBills(List<Billhf> bills) {
        this.bills = bills;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billmfPK != null ? billmfPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Billmf)) {
            return false;
        }
        Billmf other = (Billmf) object;
        if ((this.billmfPK == null && other.billmfPK != null) || (this.billmfPK != null && !this.billmfPK.equals(other.billmfPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Billmf[ billmfPK=" + billmfPK + " ]";
    }
    
}
