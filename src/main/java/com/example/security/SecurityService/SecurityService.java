package com.example.security.SecurityService;


import com.example.security.command.UserVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface SecurityService {

    public UserVO Login(String username);


    public int join(UserVO vo);



}
