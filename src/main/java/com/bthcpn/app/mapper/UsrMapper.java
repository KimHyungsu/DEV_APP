package com.bthcpn.app.mapper;

import com.bthcpn.app.dto.UsrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface로 만들면 함수 몸체를 구현하지 않아도 되기 때문에 interface로 만든다.
@Repository
@Mapper
public interface UsrMapper {

    public List<UsrInfo> usrInfo() throws Exception;

    //usrMapper.insertUsrInfo(name,email,phone,r1,inAmt,outAmt);
    void insertUsrInfo( @Param("name") String name,
                        @Param("email") String email,
                        @Param("phone") String phone,
                        @Param("r1") String r1,
                        @Param("inAmt") String inAmt,
                        @Param("outAmt") String outAmt);

    public List<UsrInfo> searchUsrInfo(@Param("name") String name,
                                       @Param("phone") String phone) throws Exception;
}
