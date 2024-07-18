package com.example.security.SecurityService;

import com.example.security.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("SecurityService")
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public int join(UserVO vo){
        String encodedPassword=bCryptPasswordEncoder.encode(vo.getPassword());
        vo.setPassword(encodedPassword); //암호화된 비밀번호로 처리
        return securityMapper.join(vo);

    }
    @Override
    public UserVO Login(String username) {
        return securityMapper.Login(username);
    }
}
