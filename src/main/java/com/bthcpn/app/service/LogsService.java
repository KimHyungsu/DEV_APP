package com.bthcpn.app.service;


import com.bthcpn.app.dto.LogsDto;
import com.bthcpn.app.mapper.LogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogsService {

    @Autowired
    LogsMapper logMapper;

    public String insertLog(LogsDto logsDto){

        int isSuccess;

        System.out.println(logsDto.toString());

        try {
            isSuccess = logMapper.insertLog(logsDto);
            System.out.println("(LogService)insertLog=============================");
            System.out.println("isSuccess : " + isSuccess);

        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
        finally {
            System.out.println("(AccountService)save end=============================");
        }

        if(isSuccess==1)//성공
            return "1";
        else{
            return "0";
        }
    }

}
