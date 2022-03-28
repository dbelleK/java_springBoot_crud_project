package com.example.crud.controller.api;

import com.example.crud.domain.Sign;
import com.example.crud.service.api.LoginApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
@RequiredArgsConstructor
public class kakaoLoginApiController {

    private final LoginApiService loginApiService;

    @ResponseBody
    @PostMapping(value="kakao/sns/login")
    public void responseSuccessLogin(Sign kakaoInfo) throws ServletException {
        loginApiService.checkUserByKakao(kakaoInfo);//checkUserByKakao 리턴 타입이 Sign
//        return signs.getEmail();
    }
}
