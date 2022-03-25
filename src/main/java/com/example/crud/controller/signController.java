package com.example.crud.controller;

import com.example.crud.domain.Sign;
import com.example.crud.service.SignService;
import com.example.crud.service.api.LoginApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class signController {

    private final SignService signService;
    private final LoginApiService loginApiService;

    @PostMapping("/signUpPro")
    public String signUpPro(Sign sign){
        signService.addUserInfo(sign);
        signService.checkUserId(sign.getId());
        return "sign/login";
    }

    @PostMapping("/loginPro")
    public String loginPro(Sign sign , Model model){
        Sign sessionUser = signService.userLoginCon(sign.getEmail());
        model.addAttribute("sessionUser",sessionUser);
        return "index";
    }

    @GetMapping("/loginBykakao")
    public String kakoLogin(String email, Model model){
        Sign sessionUser = signService.userLoginCon(email);
        model.addAttribute("sessionUser",sessionUser);
        return "index";
    }











}
