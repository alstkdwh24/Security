package com.example.security.SecurityService;


import com.example.security.command.UserVO;

public interface SecurityService {

    public UserVO Login(String username, String password);


    public int join(UserVO vo);

}
