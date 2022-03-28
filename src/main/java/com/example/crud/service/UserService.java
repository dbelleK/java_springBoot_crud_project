package com.example.crud.service;

import com.example.crud.config.security.SpringUser;
import com.example.crud.domain.Sign;
import com.example.crud.domain.UserAuthority;
import com.example.crud.repository.MypageRepository;
import com.example.crud.repository.SignRepository;
import com.example.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MypageRepository mypageRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void joinUser(Sign users) {
        //비밀번호 암호화
        users.setPass(passwordEncoder.encode(users.getPass()));
        //회원가입
        userRepository.joinUserInfo(users);
        //이메일로 유저정보 조회
//        Sign user = userRepository.getUserInfo(users.getEmail()); //자동적으로 idx 들어감
        //찾아온 유저정보가 있다면?
        if (users.getIdx() != 0) {
            UserAuthority userAuthority = new UserAuthority();
            userAuthority.setUserId((long)users.getIdx());
            userAuthority.setAuthority("ROLE_USER");
            //유저권한 데이터 삽입
            userRepository.insertAuthority(userAuthority);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Sign user = userRepository.getUserInfo(email);
        if(user != null){
            List<UserAuthority> authority = userRepository.(user.getId());


        }else {

        }

//        Optional<Sign> optionalUser = signRepository.findByEmail(username);
//        return optionalUser.map(user -> {
//            List<UserAuthority> authority = userRepository.findAuthorityById(user.getId());
//
//            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//            for (UserAuthority userAuthority : authority) {
//                grantedAuthorities.add(new SimpleGrantedAuthority(userAuthority.getAuthority()));
//            }
//
//            SpringUser springUser = new SpringUser(user.getEmail(), user.getPass(), grantedAuthorities, user);
//
//            return springUser;
//
//        }).orElseThrow(() -> new BadCredentialsException("일치하지 않습니다."));
    }

    public void logout() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
    }

    public void withdrawal(Sign users) {
        users.setPass(passwordEncoder.encode("hellomoca"));
        mypageRepository.deleteAuthority(users);
        mypageRepository.deleteUser(users);
    }

}
