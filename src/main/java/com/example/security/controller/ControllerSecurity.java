package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/SecurityLogin")
public class ControllerSecurity {

    @GetMapping("/join")
    public String join(){
        return "/SecurityLogin/join";
    }

    //시큐러티가 처음 적용되면, 모든 페이지는 시큐러티가 요청을 가로채서 login페이지로 연결을 합니다.
    //login페이지는 시큐러티가 제공해주는 기본페이지가 되기 때문에 . 병도의 설정으로 지정을 해야 됩니다.
    @GetMapping("/login")
    public String login(){
        return "/SecurityLogin/login";
    }
    @GetMapping("/main")
    public String main(){
        return "/SecurityLogin/main";
    }

    @GetMapping("/all")
    public String all(){
        return "/SecurityLogin/all";
    }

    @GetMapping("/user/mypage")
    public @ResponseBody String mypage(){
        return "REST방식의 홈페이지";
    }

    @GetMapping("/admin/mypage")
    public @ResponseBody String admin(){
        return "REST 방식의 어드민페이지";
    }

}
