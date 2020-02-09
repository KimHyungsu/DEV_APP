package com.bthcpn.app.mapper;


import com.bthcpn.app.dto.VenderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VenderMapper {

    public List<VenderDto> getVenderAll() throws Exception;

    String loginVenderChk(@Param("venderId") String venderId,
                          @Param("venderPw") String venderPw) throws Exception;

}
