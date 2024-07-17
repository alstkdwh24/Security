package com.example.security.SecurityService;

import com.example.security.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SecurityService")
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;



    public int join(UserVO vo){
        return securityMapper.join(vo);
    }
    @Override
    public UserVO Login(String username,String password) {
        return securityMapper.Login(username,password);
    }
}
