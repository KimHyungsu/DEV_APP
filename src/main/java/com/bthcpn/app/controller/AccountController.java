package com.bthcpn.app.controller;

import com.bthcpn.app.dto.Account;
import com.bthcpn.app.mapper.AccountMapper;
import com.bthcpn.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountMapper accountMapper;

    @GetMapping("/create")
    public Account create(){
        Account account = new Account();
        account.setId("admin");
        account.setPassword("1234");


        System.out.println(account.getPassword());
        accountService.save(account, "ROLE_MEMBER");

        return account;
    }

}
