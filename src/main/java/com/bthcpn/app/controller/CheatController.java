package com.bthcpn.app.controller;


import com.bthcpn.app.dto.CheatDto;
import com.bthcpn.app.service.CheatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CheatController {

    @Autowired
    CheatService cheatService;

    //대출치트 페이지
    @RequestMapping("/cheatPage")
    public String cheatPage(Model model) throws Exception{
        //List<UsrInfo> usrInfo = usrService.usrInfo();
        return "cheatPage";
    }

    //검색
    //사용자 이름이나 폰번호로 검색한다
    @RequestMapping(value = "/searchCheat", method= RequestMethod.POST)
    @ResponseBody
    public List searchCheat(//@RequestParam("BASE_DT") String BASE_DT,
                            @RequestParam("CUST_NM") String CUST_NM,
                            @RequestParam("PHONE_NO") String PHONE_NO,
                            /*
                            @RequestParam("BIRTH_YMD") String BIRTH_YMD,
                            @RequestParam("SALARY_DIV_NM") String SALARY_DIV_NM,
                            @RequestParam("ING_DIV_NM") String ING_DIV_NM,
                            @RequestParam("COUNTRY_NM") String COUNTRY_NM,
                            @RequestParam("INCOME_AMT") String INCOME_AMT,
                            @RequestParam("OUT_AMT") String OUT_AMT,
                            @RequestParam("MEMO") String MEMO,
                            @RequestParam("RGST_ID") String RGST_ID,
                            @RequestParam("CHNG_ID") String CHNG_ID,*/
                            Model model) throws Exception{


        System.out.println("========컨트롤러 진입(CheatController : searchCheat)");
        System.out.println("이름 : " + CUST_NM + ", 전화번호 : " + PHONE_NO);

        List<CheatDto> cheatDtoList = cheatService.searchCheat(CUST_NM,PHONE_NO);
        //model.addAttribute("cheatDtoList",cheatDtoList);

        return cheatDtoList;
    }


    @RequestMapping(value = "/insertCheat", method= RequestMethod.POST)
    @ResponseBody
    public String insertCheat(@RequestParam("BASE_DT") String BASE_DT,
                               @RequestParam("CUST_NM") String CUST_NM,
                               @RequestParam("PHONE_NO") String PHONE_NO,
                               @RequestParam("BIRTH_YMD") String BIRTH_YMD,
                               @RequestParam("SALARY_DIV_NM") String SALARY_DIV_NM,
                               @RequestParam("ING_DIV_NM") String ING_DIV_NM,
                               @RequestParam("COUNTRY_NM") String COUNTRY_NM,
                               @RequestParam("INCOME_AMT") String INCOME_AMT,
                               @RequestParam("OUT_AMT") String OUT_AMT,
                               @RequestParam("MEMO") String MEMO,
                               @RequestParam("RGST_ID") String RGST_ID,
                               @RequestParam("CHNG_ID") String CHNG_ID,
                               Model model) throws Exception{

        System.out.println("========컨트롤러 진입(CheatController : insertCheat)");
        System.out.println(   "기준일자    : " + BASE_DT
                + "\n고객명     : " + CUST_NM
                + "\n휴대전화번호  : " + PHONE_NO
                + "\n생년월일    : " + BIRTH_YMD
                + "\n소득구분명   : " + SALARY_DIV_NM
                + "\n진행구분명   : " + ING_DIV_NM
                + "\n지역명     : " + COUNTRY_NM
                + "\n소득금액    : " + INCOME_AMT
                + "\n대출금액    : " + OUT_AMT
                + "\n메모      : " + MEMO
                + "\n등록자ID   : " + RGST_ID
                + "\n수정자ID   : " + CHNG_ID
        );
        if(ING_DIV_NM == ""){
            ING_DIV_NM = "조회";
        }
        cheatService.insertCheat(BASE_DT.replace("-",""),
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
                                CHNG_ID
                        );
        return "1";
    }


}
