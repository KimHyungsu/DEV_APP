package com.bthcpn.app.controller;

import com.bthcpn.app.dto.UsrInfo;
import com.bthcpn.app.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    UsrService usrService;


    //테스트더미
    @RequestMapping("/DUMMY")
    public String DUMMY() throws Exception{
        return "DUMMY";
    }

    //메인페이지
    @RequestMapping("/index")
    public String index() throws Exception{
        return "index";
    }

    //대출신청고객조회
    @RequestMapping("/loanAppList")
    public String loanAppList(Model model) throws Exception{
        //List<UsrInfo> usrInfo = usrService.usrInfo();

        return "loanAppList";
    }


    //신용한도조회
    @RequestMapping("/entSaveUsrInfo")
    public String entSaveUsrInfo() throws Exception{
        return "entSaveUsrInfo";
    }

    //어드민페이지
    @RequestMapping("/adminPageHome")
    public String adminPageHome() throws Exception{
        return "adminPageHome";
    }

    @RequestMapping(value = "/sendSaveUsrInfo", method= RequestMethod.POST)
    public String sendSaveUsrInfo(@RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("r1") String r1,
                                  @RequestParam("inAmt") String inAmt,
                                  @RequestParam("outAmt") String outAmt,
                                  Model model) throws Exception{
        System.out.println(name+email+phone+inAmt+outAmt+r1);

        usrService.insertUsrInfo(name, email, phone, r1, inAmt, outAmt);

        return "entSaveUsrInfoCfm";
    }

    @RequestMapping("/entLoanInfo")
    public String hello() throws Exception{
        return "entLoanInfo";
    }

    //사용자검색

    @RequestMapping(value = "/searchUsrInfo", method= RequestMethod.POST)
    public String searchUsrInfo(@RequestParam("name") String name,
                                @RequestParam("phone") String phone,
                                Model model) throws Exception{


        System.out.println("[searchUsrInfo] 이름 : " + name + ", 전화번호 : " + phone);

        List<UsrInfo> usrInfo =  usrService.searchUsrInfo(name,phone);

        //model.addAttribute("usrInfo",usrInfo);

        System.out.println(usrService.searchUsrInfo(name,phone).toString());
        model.addAttribute("usrInfo",usrInfo);

        return "loanAppList";
    }

    @RequestMapping(value = "/searchUsrInfo2", method= RequestMethod.POST)
    @ResponseBody
    public List searchUsrInfo2(@RequestParam("name") String name,
                              @RequestParam("phone") String phone,
                              Model model) throws Exception{


        System.out.println("[searchUsrInfo] 이름 : " + name + ", 전화번호 : " + phone);

        List<UsrInfo> usrInfo =  usrService.searchUsrInfo(name,phone);

        model.addAttribute("usrInfo",usrInfo);

        return usrInfo;
    }


    @RequestMapping(value = "/saveCustRgst", method= RequestMethod.POST)
    @ResponseBody
    public String saveCustRgst(@RequestParam("sDate") String date,
                             @RequestParam("sName") String name,
                             @RequestParam("sPhone") String phone,
                             @RequestParam("sWireAgency") String agency,
                             @RequestParam("sIngYn") String ingYn,
                             @RequestParam("sCountry") String country,
                             Model model) throws Exception{

        System.out.println("[saveCustRgst] 이름 : " + name
                + ", 전화번호 : " + phone
                + ", 날짜 : " + date
                + ", 통신사 : " + agency
                + ", 진행상태 : " + ingYn
                + ", 지역 : " + country);

        //List<UsrInfo> usrInfo =  usrService.searchUsrInfo(name,phone);
        //model.addAttribute("usrInfo",usrInfo);

        return "1";
    }

}
