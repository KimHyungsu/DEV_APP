package com.bthcpn.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.bthcpn.app.dto.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface AccountMapper {


    //@Select("SELECT * FROM CPNAPP.MEMBER WHERE id=#{id}")
    Account findById(String id);

    //@Select("SELECT authority_name FROM CPNAPP.MEMBER_AUTHORITY WHERE id=#{id}")
    List getAuthorities(String id);
    //public Stinrg getAuthorities(String id);

    //@Insert("INSERT INTO CPNAPP.MEMBER VALUES(#{account.id},#{account.password},#{account.isAccountNonExpired},#{account.isAccountNonLocked},#{account.isCredentialsNonExpired},#{account.isEnabled})")
    public int insertUser(@Param("account") Account account);

    //@Insert("INSERT INTO CPNAPP.MEMBER_AUTHORITY VALUES(#{id},#{autority})")
    public int insertUserAutority(@Param("id") String id, @Param("autority") String autority);

    @Select("SELECT* FROM CPNAPP.MEMBER")
    List readAllUsers();


}
