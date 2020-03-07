package com.bthcpn.app.domain.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


import com.bthcpn.app.dto.Account;
import com.bthcpn.app.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountRepository {

    @Autowired
    AccountMapper accountMapper;

    public Account save(Account account, String role){
        accountMapper.insertUser(account);
        accountMapper.insertUserAutority(account.getId(), role);
        return account;
    }

    /*
    public Account findById(String username){
        return accountMapper.readAccount(username);
    }


    public List<String>findauthoritiesbyid(String username) {
        return accountMapper.readautorities(username);
    }
    */
    public List<String> findAuthoritiesByID(String username) {
        return null;
    }
}