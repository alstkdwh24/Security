package com.example.security.demoSecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //설정파일임
@EnableWebSecurity //이 설정파일을 시큐리티 필터에 등록을 시킴
public class SecurityConfig {
    @Autowired
    private MyUserDetailsService userDetailsService;

    //비밀번호 암호화(시큐러티가 제공해줌)
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
   //csrf토큰이 있는데, 사용안함x
        http.csrf().disable();



    //권한설정
        //모든 요청에 대해서 사용자 인증이 필요합니다.
//        http.authorizeRequests((authorize)->authorize.anyRequest().authenticated());//인증 로그인

        //특정페이지 인증
        //main페이지는 인증이 필요함
        //http.authorizeRequests((authorize)->authorize.antMatchers("/main").authenticated());
//        //user/모든경로는 인증이 필요합니다.
//http.authorizeRequests((authorize)->authorize.antMatchers("/SecurityLogin/**").authenticated()
//        .antMatchers("/user/**").authenticated()
//       );
//유저페이지는 USER권한이 필요함, 어드민페이지는 ADMIN권한이 필요함(인증이 되더라도 권한이라는게 필요)
//        http.authorizeRequests((authorize)-> authorize.antMatchers("/SecurityLogin/**").hasRole("user")
//                .antMatchers("/admin/**").hasRole("admin"));





//        //all은 인증필요, 유저페이지는 user권한이 필요함,어드민페이지는 ADMIN권한이 필요함, 나머지 모든 요청은 허용
//
//
//        http.authorizeRequests((authorize)->authorize.antMatchers("/all").authenticated()
//        .antMatchers("/user/**").hasRole("user")
//        .antMatchers("/admin/**").hasRole("admin")
//        .anyRequest());



//권한명 앞에는 default로 ROLE_가 붙습니다.


//all은 인증필요
//        user는 user or admin or tester 중 1개 권한만 가지면 접근가능
//        admin은 admin이어야 접근가능
//        나머지 모든 요청은 허용
        http.authorizeRequests((authorize)->authorize.antMatchers("all").authenticated()
                .antMatchers("/user/**").hasAnyRole("tester","admin","user")
        .antMatchers("/admin/**").hasRole("admin")
                .anyRequest().permitAll());




        //시큐러티 기반의 플로그인을 사용한다.
        http.formLogin()
                .loginPage("/SecurityLogin/loginlogin") // 커스터마이징된 로그인 페이지 경로
                .loginProcessingUrl("/SecurityLogin/loginForms") ;// 로그인 처리 URL
//                .usernameParameter("yyy") // 사용자명 파라미터 이름 설정
//                .passwordParameter("xxx"); //패스워드 파라미터 변경 시에 씋수있고
    return http.build();
    }


}
