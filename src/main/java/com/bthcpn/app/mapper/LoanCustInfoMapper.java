package com.bthcpn.app.mapper;

import com.bthcpn.app.dto.LoanCustInfoDto;
import com.bthcpn.app.dto.UsrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//interface로 만들면 함수 몸체를 구현하지 않아도 되기 때문에 interface로 만든다.
@Repository
@Mapper
public interface LoanCustInfoMapper {

    public List<LoanCustInfoMapper> loanCustInfo() throws Exception;

    public int insertloanCustInfo(@Param("loanCustInfoDto") LoanCustInfoDto loanCustInfoDto) throws Exception;

}
