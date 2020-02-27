package com.bthcpn.app.mapper;


import com.bthcpn.app.dto.CheatDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface로 만들면 함수 몸체를 구현하지 않아도 되기 때문에 interface로 만든다.
@Repository
@Mapper
public interface CheatMapper {

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


    // 치트페이지 고객 등록
    void insertCheat( @Param("BASE_DT") String BASE_DT,
                         @Param("CUST_NM") String CUST_NM,
                         @Param("PHONE_NO") String PHONE_NO,
                         @Param("BIRTH_YMD") String BIRTH_YMD,
                         @Param("SALARY_DIV_NM") String SALARY_DIV_NM,
                         @Param("ING_DIV_NM") String ING_DIV_NM,
                         @Param("COUNTRY_NM") String COUNTRY_NM,
                         @Param("INCOME_AMT") String INCOME_AMT,
                         @Param("OUT_AMT") String OUT_AMT,
                         @Param("MEMO") String MEMO,
                         @Param("RGST_ID") String RGST_ID,
                         @Param("CHNG_ID") String CHNG_ID
    );

    // 치트페이지 고객 검색
    public List<CheatDto> searchCheat(@Param("CUST_NM") String name,
                                      @Param("PHONE_NO") String phone) throws Exception;

}
