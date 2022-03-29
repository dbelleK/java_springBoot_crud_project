package com.example.crud.controller;

import com.example.crud.domain.Sign;
import com.example.crud.service.UserService;
import com.example.crud.service.api.LoginApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final LoginApiService loginApiService;

    @PostMapping("/signUpPro") //회원가입
    public String signUpPro(Sign sign) {
        userService.joinUserInfo(sign); //회원가입(권한도)

//        signService.checkUserId(sign);
        return "user/login";
    }
}


    //security 적용으로 컨트롤러에서 따로 매핑하지 않아도 된다.

    //webSecurityConfig 적용//
//    @PostMapping("/loginPro") //이메일로그인
//    public String loginPro(Sign sign){
////        Sign sessionUser = signService.userLoginCon(sign.getEmail());
////        model.addAttribute("sessionUser",sessionUser); //Model model
//
//        userService.loadUserByUsername(sign.getEmail());
//
//        return "index";
//    }


    //CustomAuthenticationProvider 적용//
//    // ajax success 연결 매핑
//    // Model로 email을 넘겨줘야지 index페이지에서 이사람이 로그인이 된 사람인지 아닌지 확인가능
//    @GetMapping("/loginBykakao") //카카오로그인
//    public String kakoLogin(String email){
//
////        Sign sessionUser = signService.userLoginCon(email);
////        model.addAttribute("sessionUser",sessionUser); //Model model 필요
//
//        loginApiService.loadUserByKakaoUser(email);
//
//        return "index";
//    }

