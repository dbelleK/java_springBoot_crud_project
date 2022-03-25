package com.example.crud.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class kakaoLoginApiController {

    @PostMapping(value="kakao/sns/login")
    public String responseSuccessLogin(String email, String id){
        return "idex";
    }
}
