package com.example.crud.service.api;

import com.example.crud.config.security.SpringUser;
import com.example.crud.domain.Sign;
import com.example.crud.domain.UserAuthority;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginApiService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;


    //todo
    // 1) 가입한 사람이 있는지 체크
    // (이메일로 가입하고 카카오로그인으로 가입시킨사람을 연동시키기 위해서 따로 둘 수 없으니까)
    // 2) 이메일로 가입했으면 카카오로그인만 회원가입 시킴
    // 3) 이메일로 가입도 안된사람이라면 이메일가입과 카카오로그인 회원가입 둘다 시킴


    public void checkUserByKakao(Sign kakaoInfo) throws ServletException {

        Sign checkInfo = userRepository.getUserInfo(kakaoInfo.getEmail()); //getUserInfo 리턴타입이 Sign

        if (checkInfo == null) { //이메일이 없는 사람 //즉,가입한 사람이 없으면 카카오아이디와 이메일 가지고 회원가입시킴

            Sign newUserInfo = new Sign();
            newUserInfo.setKakaoId(kakaoInfo.getKakaoId());
            newUserInfo.setEmail(kakaoInfo.getEmail());

            newUserInfo.setProfile(kakaoInfo.getProfile());
            newUserInfo.setBirthday(kakaoInfo.getBirthday());
            userRepository.joinUserInfo(newUserInfo); //insert쿼리문 이용 //회원가입시킴

            //권한 삽입
            UserAuthority userAuthority = new UserAuthority();
            userAuthority.setUserId((long) newUserInfo.getIdx());
            userAuthority.setAuthority("ROLE_USER");
            userRepository.insertAuthority(userAuthority); //권한 회원가입 시킴

            // return newUserInfo;
            //로그인 시키기
            kakaoLogin(newUserInfo.getEmail());

        } else {

            //기존에 가입한 사람은 권한이 있을 때니까 권한 삽입 안해줘도 됨
            //이메일로 가입한 사람이 있으면 카카오아이디만 가지고 와서 회원가입 시킴

            if (checkInfo.getKakaoId() == null) {
                // 카카오 아이디 업데이트
                checkInfo.setKakaoId(kakaoInfo.getKakaoId());

                checkInfo.setProfile(kakaoInfo.getProfile());
                checkInfo.setBirthday(kakaoInfo.getProfile());

                userRepository.updateUserByKakao(checkInfo);

                //return checkInfo;
                //로그인 시키기
                kakaoLogin(checkInfo.getEmail());

            } else {
                // 카카오 아이디가 이미 존재하기 때문에 로그인만 진행
                //return checkInfo;
                //로그인 시키기
                kakaoLogin(checkInfo.getEmail());
            }
        }
    }

    public void kakaoLogin(String email) throws ServletException {
        httpServletRequest.login(email, "moca-web-kakao-login"); //카카오아이디화원가입 초기화 비번
    }

    //비밀번호 없이도 로그인 가능한 로직
    //1.카카오 로그인을 통해 유저정보를 얻는 메소드

    public UserDetails loadUserByKakaoUser(String email) throws UsernameNotFoundException {
        Sign user = userRepository.getUserInfo(email);
        if (user != null) {
            List<UserAuthority> authority = userRepository.findAuthorityById((long) user.getIdx());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (UserAuthority userAuthority : authority) {
                grantedAuthorities.add(new SimpleGrantedAuthority(userAuthority.getAuthority()));
            }
            SpringUser springUser = new SpringUser(user.getEmail(), "moca-web-kakao-login", grantedAuthorities, user);
            return springUser;
        } else {
            throw new IllegalArgumentException(email + " 사용자가 존재하지 않습니다");
        }
    }
}
