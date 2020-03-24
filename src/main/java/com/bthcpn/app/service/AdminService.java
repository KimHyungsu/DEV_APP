package com.bthcpn.app.service;

import com.bthcpn.app.dto.Account;
import com.bthcpn.app.dto.LoanCustInfoDto;
import com.bthcpn.app.dto.UsrInfo;
import com.bthcpn.app.mapper.LoanCustInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    LoanCustInfoMapper loanCustInfoMapper;

    //조회
    public List<LoanCustInfoMapper> loanCustInfo() throws Exception{
        System.out.println("2. 서비스 진입");
        return loanCustInfoMapper.loanCustInfo();
    }
    //추가
    public String insertloanCustInfo(LoanCustInfoDto loanCustInfoDto) throws Exception {

        int isur;

        isur = loanCustInfoMapper.insertloanCustInfo(loanCustInfoDto);

        System.out.println("========서비스 진입(AdminService : insertloanCustInfo)");
        System.out.println("isur : " + isur);


        if(isur==1)//성공
            return "1";
        else{
            return "0";
        }
    }


}
