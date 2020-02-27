package com.bthcpn.app.service;

import com.bthcpn.app.dto.CheatDto;
import com.bthcpn.app.mapper.CheatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CheatService {

    @Autowired
    CheatMapper cheatMapper;

    public void insertCheat(String BASE_DT,
                              String CUST_NM,
                              String PHONE_NO,
                              String BIRTH_YMD,
                              String SALARY_DIV_NM,
                              String ING_DIV_NM,
                              String COUNTRY_NM,
                              String INCOME_AMT,
                              String OUT_AMT,
                              String MEMO,
                              String RGST_ID,
                              String CHNG_ID) throws  Exception{
        System.out.println("========서비스 진입(CheatService : insertUsrInfo)");

        cheatMapper.insertCheat(BASE_DT,
                                CUST_NM,
                                PHONE_NO,
                                BIRTH_YMD,
                                SALARY_DIV_NM,
                                ING_DIV_NM,
                                COUNTRY_NM,
                                INCOME_AMT,
                                OUT_AMT,
                                MEMO,
                                RGST_ID,
                                CHNG_ID);
    }


    public List<CheatDto> searchCheat(String CUST_NM, String PHONE_NO) throws Exception{
        System.out.println("========서비스 진입(CheatService : searchCheat)");
        System.out.println("CUST_NM : " + CUST_NM);
        System.out.println("PHONE_NO : " + PHONE_NO);
        return cheatMapper.searchCheat(CUST_NM, PHONE_NO);
    }
}
