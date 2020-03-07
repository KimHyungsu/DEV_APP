package com.bthcpn.app.controller;

import com.bthcpn.app.dto.Account;
import com.bthcpn.app.mapper.AccountMapper;
import com.bthcpn.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
