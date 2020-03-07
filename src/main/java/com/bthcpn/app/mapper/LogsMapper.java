package com.bthcpn.app.mapper;


import com.bthcpn.app.dto.Account;
import com.bthcpn.app.dto.LogsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LogsMapper {


    //@Select("SELECT authority_name FROM CPNAPP.MEMBER_AUTHORITY WHERE id=#{id}")
    //List getAuthorities(String id);
    //public Stinrg getAuthorities(String id);

    //@Insert("INSERT INTO CPNAPP.MEMBER VALUES(#{account.id},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
    //public int insertUser(@Param("account") Account account);


    public int insertLog(@Param("logsDto")LogsDto logsDto);
}
