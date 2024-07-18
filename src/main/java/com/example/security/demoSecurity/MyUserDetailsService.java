package com.example.security.demoSecurity;

import com.example.security.SecurityService.SecurityMapper;
import com.example.security.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //빈으로 등록되어 있으면 스프링이 UserDetailService타입을 찾아서 사용자가 로그인시 loadUserByUsername을 실행시킴
public class MyUserDetailsService implements UserDetailsService {



    @Autowired
    private SecurityMapper securityMapper;
    //loginProcessingUrl에 로그인URL울 등록
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("사용자가 로그인을 시도함");
        System.out.println("사용자가 입력한 이름");

        UserVO vo = securityMapper.Logins(username);
        System.out.println(vo);

        //회원정보가 없음 ->비밀번호 비교를 하기 위해서 UserDetails타입으로 리턴
        if (vo != null) {


            return new MyUserDetails(vo); //스프링 스큐리티가 비밀번호 비교, 롤 확인도 해서 로그인 처리

        } else {
            //시큐러티에 설정한 형식대로, 권한처리까지 처리를 해 줍니다.
            //만약 아이디가 없거나, 바밀번호가 틀리면 login?error로 기본 이동합니다.
            //시큐러티는 특별한 세션 모형으로 사용함
            //시쿠러티는 (new Authentication(new MyUserDetail())모형으로 저장시킵니다.


            return null;
        }



    }

    }