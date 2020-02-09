package com.bthcpn.app.controller;


import com.bthcpn.app.dto.VenderDto;
import com.bthcpn.app.service.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class VenderController {

    @Autowired
    VenderService venderService;

    //전문가/업체 로그인
    @RequestMapping("/login_venderChk")
    public String loginVenderChk(@RequestParam("VENDER_ID") String venderId,
                                 @RequestParam("VENDER_PW") String venderPw,
                                 Model model, HttpSession session) throws Exception{

        System.out.println("(Controller)loginVenderChk=============================");
        System.out.println("VENDER_ID : " + venderId);
        System.out.println("VENDER_PW : " + venderPw);

        //세션초기화
        session.setAttribute("chkVal", 0);
        String chkVal = venderService.loginVenderChk(venderId,venderPw);
        if(chkVal == null) {
            chkVal = "0";
        }
        System.out.println("chkVal : " + chkVal);
        //model.addAttribute("chkVal",chkVal);

        //http 세션으로 파라미터 넘김
        session.setAttribute("chkVal", chkVal);



        if(chkVal =="0"){
            return "redirect:/login_vender";
        }else{
            return "redirect:/usrInfoTb";
        }
    }

    //전문가/업체 로그인
    @RequestMapping("/login_vender")
    public String loginVender(Model model, HttpSession session) throws Exception{

        //세션 파라미터를 받아온다
        String chkVal = (String) session.getAttribute("chkVal");

        //모델에 주입
        model.addAttribute("chkVal", chkVal);
        System.out.println("loginVender : " + chkVal);

        return "login_vender";

    }

}
