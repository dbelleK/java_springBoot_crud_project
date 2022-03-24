package com.example.crud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    ///특정 페이지 접속할 수 없게 권한 준다 (예를 들어서 마이페이지 같은 경우 로그인을 해야만 들어갈 수 있으니까)
    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final SessionRegistry sessionRegistry;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        CustomLoginSuccessHandler handler = new CustomLoginSuccessHandler();
//        handler.addIgnoreUrl("/loginPro");
//        handler.addIgnoreUrl("/login");
    }


}
