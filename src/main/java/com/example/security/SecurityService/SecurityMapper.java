package com.example.security.SecurityService;

import com.example.security.command.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecurityMapper {

    UserVO Logins(String username);

    UserVO Login(String username);

    public int join(UserVO vo);



}
