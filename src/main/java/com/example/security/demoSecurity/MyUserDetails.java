package com.example.security.demoSecurity;

import com.example.security.command.UserVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    //로그인에서 조회한 UserVO객체
    private final UserVO userVO;


//반드시 UserVO객체를 맴버변수로 담고 생성
    public MyUserDetails(UserVO vo) {
        this.userVO=vo;
    }
    //부가적으로 추가하고 싶은거 있으면 추가하면 됨
    //롤 리턴
    public String getrole(){
        return userVO.getRole();
    }

    //사용자의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       //Collection은 리스트의 부모
        List<GrantedAuthority> list= new ArrayList<>();

        //권한이 여러개 라면 반복은 돌리면 됩니다.

        list.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userVO.getRole();
            }
        });

        return list;
    }

    @Override
    public String getPassword() {

        return userVO.getPassword();//패스워드를 리턴
    }

    @Override
    public String getUsername() {
        return userVO.getUsername();//아이디를 리턴
    }

    @Override
    public boolean isAccountNonExpired() {



        return true; //계정이 완료되지 않았습니까?(true면 네)
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;//계정이 락이 걸리지 않았습니까
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; //비밀번호 완료되안았습니까?
    }

    @Override
    public boolean isEnabled() {
        return true; //계정이 완료되지 않았습니까?
    }


}
