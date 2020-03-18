package com.bthcpn.app.controller;

import com.bthcpn.app.dto.CheatDto;
import com.bthcpn.app.dto.UsrInfo;
import com.bthcpn.app.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UsrService usrService;

    //어드민페이지
    @RequestMapping("/adminPageMember")
    public String adminPageMember() throws Exception{
        return "adminPageMember";
    }

    //어드민페이지
    @RequestMapping("/adminPageHome")
    public String adminPageHome() throws Exception{
        return "adminPageHome";
    }


    @RequestMapping(value = "/searchMemberList", method= RequestMethod.POST)
    public String searchMemberList(//@RequestParam("BASE_DT") String BASE_DT,
                                         //@RequestParam("CUST_NM") String CUST_NM,
                                         //@RequestParam("PHONE_NO") String PHONE_NO,
                                         Model model) throws Exception{


        System.out.println("========컨트롤러 진입(AdminController : searchMemberList)");

        List<UsrInfo> memberList = usrService.usrInfo();
        model.addAttribute("memberList",memberList);

        //model.addAttribute("memberList", memberList);
        return "adminPageMember";
    }

    @RequestMapping(value = "/searchMemberList2", method= RequestMethod.POST)
    @ResponseBody
    public List searchMemberList2(Model model) throws Exception{


        System.out.println("========컨트롤러 진입(AdminController : searchMemberList)");

        List<UsrInfo> data = usrService.usrInfo();
        //model.addAttribute("data",data);

        return data;
    }

}
