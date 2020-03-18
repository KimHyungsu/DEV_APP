package com.bthcpn.app.controller;

import com.bthcpn.app.dto.UsrInfo;
import com.bthcpn.app.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UsrService usrService;


    //메인페이지
    @RequestMapping("/index")
    public String index() throws Exception{
        return "index";
    }

    //신용한도조회
    @RequestMapping("/entSaveUsrInfo")
    public String entSaveUsrInfo() throws Exception{
        return "entSaveUsrInfo";
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



}
