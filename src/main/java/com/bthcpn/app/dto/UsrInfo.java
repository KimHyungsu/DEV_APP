package com.bthcpn.app.dto;


import lombok.Data;

@Data
public class UsrInfo {

    // BASE_DT       /* 기준일자 */
    // CUST_NM       /* 고객명 */
    // PHONE_NO      /* 휴대전화번호 */
    // BIRTH_YMD     /* 생년월일 */
    // SALARY_DIV_NM /* 소득구분명 */
    // ING_DIV_NM    /* 진행구분명 */
    // COUNTRY_NM    /* 지역명 */
    // INCOME_AMT    /* 소득금액 */
    // OUT_AMT       /* 대출금액 */
    // MEMO          /* 메모 */
    // RGST_ID       /* 등록자ID */
    // RGST_DTTM     /* 등록시간 */
    // CHNG_ID       /* 수정자ID */
    // CHNG_DTTM     /* 수정시간 */

    private String seq;
    private String custNm;
    private String email;
    private String carrierCd;
    private String carrierNm;
    private String phoneNo;
    private String jboCd;
    private String jobNm;
    private String incmAmt;
    private String hopLoanAmt;



}
