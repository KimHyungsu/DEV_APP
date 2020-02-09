package com.bthcpn.app.service;

import com.bthcpn.app.mapper.VenderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenderService {

    @Autowired
    VenderMapper venderMapper;

    public String loginVenderChk(String venderId, String venderPw) throws Exception {

        System.out.println("(Service)loginVenderChk=============================");
        System.out.println("VENDER_ID : " + venderId);
        System.out.println("VENDER_PW : " + venderPw);

        return venderMapper.loginVenderChk(venderId, venderPw);
    }
}
