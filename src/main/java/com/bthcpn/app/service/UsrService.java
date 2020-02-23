package com.bthcpn.app.service;



import com.bthcpn.app.dto.UsrInfo;
import com.bthcpn.app.mapper.UsrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrService {


    @Autowired
    UsrMapper usrMapper;

    public List<UsrInfo> usrInfo() throws Exception{
        System.out.println("2. 서비스 진입");
        return usrMapper.usrInfo();
    }

    public void insertUsrInfo(String name,
                                String email,
                                String phone,
                                String r1,
                                String inAmt,
                                String outAmt) throws  Exception{
        System.out.println("2. 서비스 진입(insertUser)");
        usrMapper.insertUsrInfo(name,email,phone,r1,inAmt,outAmt);
    }


    public List<UsrInfo>  searchUsrInfo(String name, String phone) throws Exception{
        System.out.println("(Service)searchUsrInfo=============================");
        System.out.println("name : " + name);
        System.out.println("phone : " + phone);
        return usrMapper.searchUsrInfo(name, phone);
    }
}
