package com.example.crud.config.security;

import com.example.crud.repository.UserRepository;
import com.example.crud.service.UserService;
import com.example.crud.service.api.LoginApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@RequiredArgsConstructor
@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

    //특정 페이지 접속할 수 없게 권한 준다 예를 들어서 마이페이 같은 경우 로그인을 해야만 들어갈 수 있으니까

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final LoginApiService loginApiService;
    public final Integer SESSION_TIMEOUT_IN_SECONDS = 30*60;
    private final HttpSession httpSession;



    //Authenticationr 기본제공
    //우리가 흔히 하는 아이디/패스워드 사용자 정보를 넣고 실제 가입된 사용자인지 체크한 후 인증에 성공하면
    //사용자의 principal과 credential 정보를 Authentication에 담습니다.

    //Authentication 객체의 getPrincipal(), getCredentials() 메서드를 실행하게 되면, UserDetails를 구현한 사용자 객체를 Return 한다.
    //UserDetails은 스프링 시큐리티를 위한 기본제공 클래스
    //Object getPrincipal(); - 주로 ID , Object getCredentials(); - 주로 비밀번호
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = (String)authentication.getPrincipal();
        String password = (String)authentication.getCredentials();
        SpringUser springUser;

        //카카오 로그인
        if(password.equals("moca-web-kakao-login")){
            springUser = (SpringUser)loginApiService.loadUserByKakaoUser(email);
            this.withdrawalFilter(springUser);
            httpSession.setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
            httpSession.setAttribute("user",springUser.getUser());
        }else {
            //스프링 시큐리티 적용 폼 로그인
            springUser = (SpringUser) userService.loadUserByUsername(email);
            this.withdrawalFilter(springUser);
            if (!passwordEncoder.matches(password, springUser.getPassword())) {
                //암호화되서 온 password와 암호화인 springUser.getPassword()가 암호화되어 있지 않으면 실패 -> 회원가입 시킬 때 비번 암호화 해주어야한다.
                // 로그인 실패 이력 남기기
//            userService.updateFailedLoginCountPlus(email);
                throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
            }
        }

        // 유저 로그인 이력 남기기
//        userService.updateMemberLoginDt(springUser.getMember().getMemberNo());
//        userService.updateFailedLoginCountInit(userId);

        //springUser = (SpringUser)snsApiService.loadUserByKakaoUser(email); springUser = (SpringUser) userService.loadUserByUsername(email);
        //성공시 UsernamePasswordAuthenticationToken(기본제공) 해주기 이게 없으면 로그인 되지 않는다.
        //인증토큰 객체 리턴
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password, springUser.getAuthorities());
        authenticationToken.setDetails(springUser);
        return authenticationToken;
    }

    /**
     * 탈퇴회원 로그인 에러 처리
     * @param springUser
     */
    public void withdrawalFilter(SpringUser springUser){
        // 탈퇴한 회원이 로그인시 권한 체크
        Collection<GrantedAuthority> authorities = springUser.getAuthorities();
        authorities.stream().forEach(auth -> {
            String role = auth.getAuthority();
            if(role.equals("DELETE")){
                throw new BadCredentialsException("탈퇴");
            }
        });
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
