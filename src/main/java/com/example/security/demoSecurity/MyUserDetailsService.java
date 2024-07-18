package com.example.security.demoSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //빈으로 등록되어 있으면 스프링이 UserDetailService타입을 찾아서 사용자가 로그인시 loadUserByUsername을 실행시킴
public class MyUserDetailsService implements UserDetailsService {


    //loginProcessingUrl에 로그인URL울 등록
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("사용자가 로그인을 시도함");
        System.out.println("사용자가 입력한 이름");
        return null;
    }
}
