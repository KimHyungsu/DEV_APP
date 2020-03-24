package com.bthcpn.app.controller;

import com.bthcpn.app.dto.CheatDto;
import com.bthcpn.app.dto.LoanCustInfoDto;
import com.bthcpn.app.dto.UsrInfo;
import com.bthcpn.app.mapper.LoanCustInfoMapper;
import com.bthcpn.app.service.AdminService;
import com.bthcpn.app.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UsrService usrService;

    @Autowired
    AdminService adminService;

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

    //대출정보 등록고객 검색
    @RequestMapping(value = "/searchloanCustInfo", method= RequestMethod.POST)
    @ResponseBody
    public List searchloanCustInfo(Model model) throws Exception{


        System.out.println("========컨트롤러 진입(AdminController : searchloanCustInfo)");

        List<LoanCustInfoMapper> data = adminService.loanCustInfo();
        //model.addAttribute("data",data);

        return data;
    }


    @RequestMapping(value = "/insertloanCustInfo", method= RequestMethod.POST)
    @ResponseBody
    public List insertloanCustInfo(/*@RequestParam("base_DT") String BASE_DT,
                                   @RequestParam("phone_NO") String PHONE_NO,
                                   @RequestParam("cust_NM") String CUST_NM,
                                   @RequestParam("aprv_AMT") String APRV_AMT,
                                   @RequestParam("colt_AMT") String COLT_AMT,*/
                                   @ModelAttribute LoanCustInfoDto loanCustInfoDto,
                                   Model model) throws Exception{

        System.out.println("========컨트롤러 진입(AdminController : insertloanCustInfo)");
        System.out.println(loanCustInfoDto.toString());

        String succFlag = adminService.insertloanCustInfo(loanCustInfoDto);
        System.out.println("성공여부 : " + succFlag);

        List<LoanCustInfoMapper> data = adminService.loanCustInfo();


        model.addAttribute("data",data);

        return data;
    }

}
