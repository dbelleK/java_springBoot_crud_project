package com.example.crud.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SessionLogin {

    @Bean("loginBean")
    @SessionScope
    public Sign loginBean(){
        return new Sign();
    }

}
