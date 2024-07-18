package com.example.security.SecurityService;

import com.example.security.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityMapper {

    public UserVO Login(String username, String password);

    public int join(UserVO vo);



}
