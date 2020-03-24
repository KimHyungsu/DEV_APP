package com.bthcpn.app.dto;

import lombok.Data;

@Data
public class LoanCustInfoDto {

    private String SEQ;
    private String BASE_DT;
    private String PHONE_NO;
    private String CUST_NM;
    private String APRV_AMT;
    private String COLT_AMT;
    private String ROUND;
    private String USEDT_CNT;
    private String RGST_ID;
    private String RGST_DTTM;
    private String CHNG_ID;
    private String CHNG_DTTM;

    private String TODAY_COLT_AMT;
    private String TOT_COLT_AMT;
    private String END_YN;

    public String getSEQ() {
        return SEQ;
    }

    public void setSEQ(String SEQ) {
        this.SEQ = SEQ;
    }

    public String getBASE_DT() {
        return BASE_DT;
    }

    public void setBASE_DT(String BASE_DT) {
        this.BASE_DT = BASE_DT;
    }

    public String getPHONE_NO() {
        return PHONE_NO;
    }

    public void setPHONE_NO(String PHONE_NO) {
        this.PHONE_NO = PHONE_NO;
    }

    public String getCUST_NM() {
        return CUST_NM;
    }

    public void setCUST_NM(String CUST_NM) {
        this.CUST_NM = CUST_NM;
    }

    public String getAPRV_AMT() {
        return APRV_AMT;
    }

    public void setAPRV_AMT(String APRV_AMT) {
        this.APRV_AMT = APRV_AMT;
    }

    public String getCOLT_AMT() {
        return COLT_AMT;
    }

    public void setCOLT_AMT(String COLT_AMT) {
        this.COLT_AMT = COLT_AMT;
    }

    public String getROUND() {
        return ROUND;
    }

    public void setROUND(String ROUND) {
        this.ROUND = ROUND;
    }

    public String getUSEDT_CNT() {
        return USEDT_CNT;
    }

    public void setUSEDT_CNT(String USEDT_CNT) {
        this.USEDT_CNT = USEDT_CNT;
    }

    public String getRGST_ID() {
        return RGST_ID;
    }

    public void setRGST_ID(String RGST_ID) {
        this.RGST_ID = RGST_ID;
    }

    public String getRGST_DTTM() {
        return RGST_DTTM;
    }

    public void setRGST_DTTM(String RGST_DTTM) {
        this.RGST_DTTM = RGST_DTTM;
    }

    public String getCHNG_ID() {
        return CHNG_ID;
    }

    public void setCHNG_ID(String CHNG_ID) {
        this.CHNG_ID = CHNG_ID;
    }

    public String getCHNG_DTTM() {
        return CHNG_DTTM;
    }

    public void setCHNG_DTTM(String CHNG_DTTM) {
        this.CHNG_DTTM = CHNG_DTTM;
    }
}
