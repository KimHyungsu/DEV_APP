package com.bthcpn.app.handler;

import com.bthcpn.app.dto.LogsDto;
import com.bthcpn.app.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private String loginidname;
    private String defaultUrl;


    @Autowired
    LogsService logsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        System.out.println("LoginSuccessHandler");

        String ip = getClientIp(request);
        String nm = authentication.getName();
        //String ip2 = request.getRemoteAddr();

        System.out.println("Client IP : " + nm);
        //System.out.println("Client IP : " + ip2);
        System.out.println("Client IP : " + ip);


        LogsDto logsDto = new LogsDto();
        logsDto.setIP_ADDR(ip);
        logsDto.setMEMBER_ID(nm);
        logsDto.setLOG_DIV_NM("LOGIN_SUCCESS");
        logsDto.setPROCESS_NM("onAuthenticationSuccess");

        //로그인 로그 인서트
        logsService.insertLog(logsDto);


        response.sendRedirect(request.getContextPath() + "/index");
                //response.sendRedirect(request.getContextPath() + "/index" + request.getParameter("url"));


    }

    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    public String getLoginidname() {
        return loginidname;
    }

    public void setLoginidname(String loginidname) {
        this.loginidname = loginidname;
    }

    public String getDefaultUrl() {
        return defaultUrl;
    }

    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

}
