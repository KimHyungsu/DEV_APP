package com.bthcpn.app.dto;

import lombok.Data;

@Data
public class LogsDto {

    public String LOG_ID;
    public String LOG_DT;
    public String LOG_DIV_NM;
    public String LOG_CTNT;
    public String PROCESS_NM;
    public String MEMBER_ID;
    public String IP_ADDR;
    public String RGST_ID;
    public String RGST_DTTM;

    public String getLOG_ID() {
        return LOG_ID;
    }

    public void setLOG_ID(String LOG_ID) {
        this.LOG_ID = LOG_ID;
    }

    public String getLOG_DT() {
        return LOG_DT;
    }

    public void setLOG_DT(String LOG_DT) {
        this.LOG_DT = LOG_DT;
    }

    public String getLOG_DIV_NM() {
        return LOG_DIV_NM;
    }

    public void setLOG_DIV_NM(String LOG_DIV_NM) {
        this.LOG_DIV_NM = LOG_DIV_NM;
    }

    public String getLOG_CTNT() {
        return LOG_CTNT;
    }

    public void setLOG_CTNT(String LOG_CTNT) {
        this.LOG_CTNT = LOG_CTNT;
    }

    public String getPROCESS_NM() {
        return PROCESS_NM;
    }

    public void setPROCESS_NM(String PROCESS_NM) {
        this.PROCESS_NM = PROCESS_NM;
    }

    public String getMEMBER_ID() {
        return MEMBER_ID;
    }

    public void setMEMBER_ID(String MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }

    public String getIP_ADDR() {
        return IP_ADDR;
    }

    public void setIP_ADDR(String IP_ADDR) {
        this.IP_ADDR = IP_ADDR;
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
}
