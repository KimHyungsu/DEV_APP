package com.bthcpn.app.service;


import com.bthcpn.app.domain.repository.AccountRepository;
import com.bthcpn.app.dto.Account;
import com.bthcpn.app.mapper.AccountMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountRepository accounts;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Account account = accounts.findById(username);
        Account account = accountMapper.findById(username); //유저 정보 검색


        if (account == null) {
            throw new UsernameNotFoundException("No user found with username" +  account.getId().toString());
        }
        //유저 롤 탐색
        //String USER_ROLE = accountMapper.getAuthorities(username)
        //System.out.println("USER_ROLE : " + USER_ROLE);

        account.setAuthorities(accountMapper.getAuthorities(username)); //유저 롤 검색

        System.out.println(new SimpleGrantedAuthority(account.getAuthorities().toString()));
        String dummy = account.getAuthorities().toString();
        String role = "";

        if(dummy.contains("ADMIN")){
            role = "ROLE_ADMIN";
        }else if(dummy.contains("MEMBER")){
            role = "ROLE_MEMBER";
        }
        System.out.println("USER_ROLE : " + role);

        Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(role)); //롤넣어주기
        if(role.equals("ROLE_ADMIN")){
            roles.add(new SimpleGrantedAuthority("ROLE_MEMBER")); //롤넣어주기
        }

        UserDetails user = new User(username, account.getPassword(), roles);

        return user; //or
        //return account;
    }

    public String save(Account account, String role){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setAccountNonExpired(true);
        account.setAccountNonLocked(true);
        account.setCredentialsNonExpired(true);
        account.setEnabled(true);
        int isur;
        int isurat;

        try {
            isur = accountMapper.insertUser(account);
            isurat = accountMapper.insertUserAutority(account.getId(), role);
            System.out.println("(AccountService)save=============================");
            System.out.println("isur : " + isur);
            System.out.println("isurat : " + isurat);

        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
        finally {
            System.out.println("(AccountService)save end=============================");
        }

        if(isur==1)//성공
            return "1";
        else{
            return "0";
        }
    }


}

