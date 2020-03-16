package com.bthcpn.app.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

    private String exceptionmsgname; //예외메시지를 request의 attribute에 저장할 변수
    private String defaultFailureUrl; //화면에 보여줄 URL(로그인 화면)
    private String exceptionmsg;

    //https://otrodevym.tistory.com/entry/Spring-Security-%EC%A0%95%EB%A6%AC-4-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%8B%A4%ED%8C%A8-%ED%9B%84-%EC%B2%98%EB%A6%AC
    public LoginFailureHandler(){
        this.exceptionmsg = "test";
        this.exceptionmsgname = "securityexceptionmsg";
        this.defaultFailureUrl ="/login_vender";
    }

    public String getExceptionmsgname() {
        return exceptionmsgname;
    }

    public void setExceptionmsgname(String exceptionmsgname) {
        this.exceptionmsgname = exceptionmsgname;
    }

    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {


        System.out.println("exceptionmsg : "+exception.getMessage());
        //화면에 뿌릴 exception msg 를 생성한다
        request.setAttribute(exceptionmsg, exception.getMessage());
        //화면으로 날린다.
        request.getRequestDispatcher("/login_verder?error=true").forward(request, response);

       //response.sendRedirect(request.getContextPath() + "/login_vender?error");
        //response.sendRedirect(request.getContextPath() + "/index" + request.getParameter("url"));
    }
}

