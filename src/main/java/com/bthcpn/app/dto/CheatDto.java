package com.bthcpn.app.dto;


import lombok.Data;

@Data
public class CheatDto {

    private String BASE_DT      ; /* 기준일자 */
    private String CUST_NM      ; /* 고객명 */
    private String PHONE_NO     ; /* 휴대전화번호 */
    private String BIRTH_YMD    ; /* 생년월일 */
    private String SALARY_DIV_NM; /* 소득구분명 */
    private String ING_DIV_NM   ; /* 진행구분명 */
    private String COUNTRY_NM   ; /* 지역명 */
    private String INCOME_AMT   ; /* 소득금액 */
    private String OUT_AMT      ; /* 대출금액 */
    private String MEMO         ; /* 메모 */
    private String RGST_ID      ; /* 등록자ID */
    private String RGST_DTTM    ; /* 등록시간 */
    private String CHNG_ID      ; /* 수정자ID */
    private String CHNG_DTTM    ; /* 수정시간 */

    public String getBASE_DT() {
        return BASE_DT;
    }

    public void setBASE_DT(String BASE_DT) {
        this.BASE_DT = BASE_DT;
    }

    public String getCUST_NM() {
        return CUST_NM;
    }

    public void setCUST_NM(String CUST_NM) {
        this.CUST_NM = CUST_NM;
    }

    public String getPHONE_NO() {
        return PHONE_NO;
    }

    public void setPHONE_NO(String PHONE_NO) {
        this.PHONE_NO = PHONE_NO;
    }

    public String getBIRTH_YMD() {
        return BIRTH_YMD;
    }

    public void setBIRTH_YMD(String BIRTH_YMD) {
        this.BIRTH_YMD = BIRTH_YMD;
    }

    public String getSALARY_DIV_NM() {
        return SALARY_DIV_NM;
    }

    public void setSALARY_DIV_NM(String SALARY_DIV_NM) {
        this.SALARY_DIV_NM = SALARY_DIV_NM;
    }

    public String getING_DIV_NM() {
        return ING_DIV_NM;
    }

    public void setING_DIV_NM(String ING_DIV_NM) {
        this.ING_DIV_NM = ING_DIV_NM;
    }

    public String getCOUNTRY_NM() {
        return COUNTRY_NM;
    }

    public void setCOUNTRY_NM(String COUNTRY_NM) {
        this.COUNTRY_NM = COUNTRY_NM;
    }

    public String getINCOME_AMT() {
        return INCOME_AMT;
    }

    public void setINCOME_AMT(String INCOME_AMT) {
        this.INCOME_AMT = INCOME_AMT;
    }

    public String getOUT_AMT() {
        return OUT_AMT;
    }

    public void setOUT_AMT(String OUT_AMT) {
        this.OUT_AMT = OUT_AMT;
    }

    public String getMEMO() {
        return MEMO;
    }

    public void setMEMO(String MEMO) {
        this.MEMO = MEMO;
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
