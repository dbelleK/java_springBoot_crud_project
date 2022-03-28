package com.example.crud.config.security;

import com.example.crud.domain.Sign;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class SpringUser extends User {

    // 내장 객체인 User은 세션처럼 성공한 객체를 담아두기 위해 서버내에서 항상 불러 쓸 수 있게
    //Users에 UserDetails 포함
    private Sign users;

    public SpringUser(String email, String password, List<GrantedAuthority> grantedAuthorities, Sign users) {
        super(email, password, grantedAuthorities);
        this.users = users;
    }

    public Sign getUser() {
        return users;
    }

    public void setUser(Sign user) {
        this.users = user;
    }
}

