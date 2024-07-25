package com.example.security.demoSecurity;

import lombok.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Custom extends SimpleUrlAuthenticationFailureHandler {

    //setter
    private String redirectURL;
    public void setRedirectURL(String redirectURL){
        this.redirectURL=redirectURL;
    }
    //인증실패시에 실행
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        super.onAuthenticationFailure(request, response, exception);

        //로그인 실패시에 다양한 어떤 처리작업을 사용하고

        if (!response.isCommitted()) {
            getRedirectStrategy().sendRedirect(request, response, "/SecurityLogin/user/deny");
        }
    }




}
