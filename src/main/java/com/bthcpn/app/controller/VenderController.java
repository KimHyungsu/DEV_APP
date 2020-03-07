package com.bthcpn.app.controller;


import com.bthcpn.app.dto.Account;
import com.bthcpn.app.service.AccountService;
import com.bthcpn.app.service.VenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class VenderController {

    @Autowired
    AccountService accountService;

    @Autowired
    VenderService venderService;

    //전문가/업체 로그인
    @RequestMapping("/login_venderChk2")
    public String loginVenderChk2(@RequestParam("VENDER_ID") String venderId,
                                 @RequestParam("VENDER_PW") String venderPw,
                                 Model model, HttpSession session) throws Exception {

        System.out.println("(Controller)loginVenderChk=============================");
        System.out.println("VENDER_ID : " + venderId);
        System.out.println("VENDER_PW : " + venderPw);
        System.out.println("----------------------------------------------");

        System.out.println( accountService.loadUserByUsername(venderId));
        //accountService.loadUserByUsername(venderId);
        return "redirect:/login_vender";
    }

    //전문가/업체 로그인
    @RequestMapping("/login_venderChk")
    public String loginVenderChk(@RequestParam("VENDER_ID") String venderId,
                                 @RequestParam("VENDER_PW") String venderPw,
                                 Model model, HttpSession session) throws Exception{

        System.out.println("(Controller)loginVenderChk=============================");
        System.out.println("VENDER_ID : " + venderId);
        System.out.println("VENDER_PW : " + venderPw);

        //세션초기화
        session.setAttribute("chkVal", null);
        String chkVal = venderService.loginVenderChk(venderId,venderPw);
        if(chkVal == null) {
            chkVal = "0";
        }
        System.out.println("chkVal : " + chkVal);
        //model.addAttribute("chkVal",chkVal);

        //http 세션으로 파라미터 넘김
        session.setAttribute("chkVal", chkVal);



        if(chkVal =="0"){//로그인실패시
            return "redirect:/login_vender";
        }else{//로그인성공시
            //return "redirect:/loanAppList";
            return "redirect:/choiceAdminMenu";
        }
    }

    //대출신청고객조회
    @RequestMapping("/choiceAdminMenu")
    public String choiceAdminMenu(Model model) throws Exception{
        return "choiceAdminMenu";
    }

    //전문가/업체 로그인
    @RequestMapping("/login_vender")
    public String login_vender(Model model, HttpSession session) throws Exception {

        //세션 파라미터를 받아온다
        String chkVal = (String) session.getAttribute("chkVal");

        //모델에 주입
        model.addAttribute("chkVal", chkVal);
        session.setAttribute("chkVal", null);
        //System.out.println("loginVender : " + chkVal);

        return "login_vender";
    }


    //회원가입
    @RequestMapping("/signup_venderChk")
    public String signup_venderChk(@RequestParam("COMPANY_NM") String companyNm,
                                   @RequestParam("VENDER_ID") String venderId,
                                   @RequestParam("VENDER_PW") String venderPw,
                                   Model model
                                , HttpSession session) throws Exception {

        System.out.println("(Controller)signup_venderChk=============================");
        System.out.println("COMPANY_NM : " + companyNm);
        System.out.println("VENDER_ID : " + venderId);
        System.out.println("VENDER_PW : " + venderPw);

        Account account = new Account();
        account.setId(venderId);
        account.setPassword(venderPw);


        //세션초기화
        session.setAttribute("chkSignVal", null);
        String chkSignVal = accountService.save(account, "ROLE_MEMBER");

        System.out.println("chkSignVal : " + chkSignVal);

        //http 세션으로 파라미터 넘김
        session.setAttribute("chkSignVal", chkSignVal);

        if(chkSignVal =="1"){//회원가입성공시
            return "redirect:/login_vender";
            //return "redirect:/signup_vender";
        }else{//회원가입실패시
            //return "redirect:/loanAppList";
            return "redirect:/signup_vender";
        }
    }

    //회원가입
    @RequestMapping("/signup_venderChk2")
    public String signup_venderChk2(@RequestParam("COMPANY_NM") String companyNm,
                                   @RequestParam("VENDER_ID") String venderId,
                                   @RequestParam("VENDER_PW") String venderPw,
                                   Model model
            , HttpSession session) throws Exception {

        System.out.println("(Controller)signup_venderChk=============================");
        System.out.println("COMPANY_NM : " + companyNm);
        System.out.println("VENDER_ID : " + venderId);
        System.out.println("VENDER_PW : " + venderPw);

        return "redirect:/login_vender";
    }

        //회원가입
    @RequestMapping("/signup_vender")
    public String signUp(Model model, HttpSession session) throws Exception{


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);

        if(!principal.equals("anonymousUser")){
            System.out.println("회원임ㅋㅋ");
            UserDetails userDetails = (UserDetails)principal;
            System.out.println(userDetails.getUsername());
            return "redirect:/index";
        }

        //세션 파라미터를 받아온다
        String chkSignVal = (String) session.getAttribute("chkSignVal");
        //모델에 주입
        model.addAttribute("chkSignVal", chkSignVal);
        session.setAttribute("chkSignVal", null);

        System.out.println("signUp");
        return "signup_vender";
    }


}
