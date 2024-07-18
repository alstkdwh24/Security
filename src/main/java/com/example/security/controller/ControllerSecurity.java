package com.example.security.controller;

import com.example.security.SecurityService.SecurityService;
import com.example.security.command.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/SecurityLogin")
public class ControllerSecurity  {

    @Autowired
    @Qualifier("SecurityService")
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @GetMapping("/loginlogin")
    public String logins(){
        return "/SecurityLogin/loginlogin";
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

    //회원가입가능
    @PostMapping("/joinForms")
    public String joinForms(UserVO vo){
        int result=securityService.join(vo);
        return "redirect:/SecurityLogin/login";
    }
    //로그인 기능
    @PostMapping("/loginForm")
    public String joinForm(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password, Model model) {

//        bCryptPasswordEncoder.encode(vo.getPassword());
//        return "redirect:/SecurityLogin/main";
// return null;
        UserVO UserVO = securityService.Login(username, password);
        System.out.println("UserVO  " + UserVO );
        if (UserVO != null) { // 일반 사용자 로그인 성공
            // 일반 사용자 권한으로 처리할 로직 추가
            return "redirect:/SecurityLogin/main";
        } else { // 로그인 실패
            model.addAttribute("message", "로그인에 실패했습니다.");
            return "redirect:/SecurityLogin/login"; // 로그인 폼 페이지로 이동
        }
    }
}
