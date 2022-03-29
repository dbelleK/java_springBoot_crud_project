package com.example.crud.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final SessionRegistry sessionRegistry;

    // SessionRegistry 클래스(기본)
    //((세션: 일정시간동안 같은 사용자로부터 들어오는 일련의 요구를 하나로 보고 그 상태를 일정하게 유지시키는 기술
    // 일정시간은 방문자가 웹 브라우저를 통해 웹 서버에 접속한 시점으로부터 웹 브라우저를 종료하여 연결을 끝내는 시점
    // ,즉 방문자가 웹 서버에 접속해 있는 상태를 하나의 단위로 보고 그것을 세션이라고 함))

    //사용자의 인증정보와 그 인증정보가 가지고 있는 세션들
    //(한 사람의 사용자가 여러 세션을 생성하면서 들어올 수 있다
    //브라우저를 달리한뒤 각각 로그인 하게 되면 하나의 사용자가 2개의 서로 다른 세션 ID를 갖게 됨)
    //하나의 브라우저로 여러개의 창을 열어도 같은 사용자 = 정보유지


    //AuthenticationManagerBuilder(기본제공)를 통해 인증 객체를 만들 수 있도록 제공
    //로그인을 위해서는 SecurityConfig 클래스에 AuthenticationManagerBuilder를 주입해서 인증에 대한 처리
    //인증 매니저들은 인증/인가를 위한 UserDetailsService를 통해서 필요한 정보들을 가져옵니다.
    //UserDetails는 사용자의 정보 + 권한 정보들의 묶음

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //CustomLoginSuccessHandler : 로그인 성공 했을 때 실행되는 클래스이니까
        //loginPro,login 성공 시 코드니까 일단 이 링크를 무시한다
        CustomLoginSuccessHandler handler = new CustomLoginSuccessHandler();
        handler.addIgnoreUrl("/loginPro");
        handler.addIgnoreUrl("/login"); //.successHandler(handler)

        http.addFilterBefore(characterEncodingFilter(), SecurityContextPersistenceFilter.class)
                .formLogin().loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("pass")
                .loginProcessingUrl("/loginPro")
                .failureHandler(new CustomLoginFailureHandler())
                .successHandler(handler)

                .and().cors()

                .and()
                .authorizeRequests() //authorizeRequests()는 시큐리티 처리에 HttpServletRequest를 이용한다는 것을 의미,요청에 대한 권한을 지정할 수 있다.
//                .antMatchers("/h2-console/*").permitAll()//antMatchers() 특정한 경로를 지정 //permitAll()는 모든 사용자가 접근할 수 있다는 것을 의미
                .antMatchers("/").permitAll()
                .antMatchers("/error").permitAll()
                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/sign/**").permitAll()
                .antMatchers("/signUpPro").permitAll() //path주소, form 태그 action
                .antMatchers("/loginPro").permitAll()
//                .antMatchers("/sign/**").hasAnyAuthority("ROLE_USER")
//                .antMatchers("/cs/**").hasAnyAuthority("ROLE_USER") //.hasAuthority() or hasAnyAuthority() : 특정 권한을 가지는 사용자만 접근할 수 있다.
//                .antMatchers("/service/copy/**").hasAnyAuthority("ROLE_USER")

                .and()
                .logout().logoutUrl("/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")

//                .and()
//                .csrf().ignoringAntMatchers("")

                .and()
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler()) //로그인 시 예외 나타날 때 부인하는 화면 출력 혹은 예외발생시

                .and()
                .rememberMe() //리멤버 기능을 통해 로그인한 사용자만 접근할 수 있음
                .key("key") //토근 내용생성할 때 사용하는 키
                .tokenValiditySeconds(1000)
//                    .userDetailsService(userService)

                .and()
                .sessionManagement()  //세션관리 클래스
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) //세션 정책이 지정된거만 세션시킨다
                .sessionFixation().newSession()//새로운 세션을 고정시킨다
                .maximumSessions(1)//세션1개
                .expiredUrl("/") //세션 만료되면 루트로 간다
                .maxSessionsPreventsLogin(false) //false로그아웃 true 거부-로그인안됨 (세션한개인데 여러개일 경우)
                .sessionRegistry(sessionRegistry); //세션 저장
    }

    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

}