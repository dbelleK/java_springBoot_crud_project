package com.example.crud.controller;

import com.example.crud.domain.Sign;
import com.example.crud.service.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
public class signController {

    private final SignService signService;

    @PostMapping("/signUpPro")
    public String signUpPro(Sign sign){
        signService.addUserInfo(sign);
        signService.checkUserId(sign.getId());
        return "sign/login";
    }

    @PostMapping("/loginPro")
    public String loginPro(Sign sign , Model model){
        Sign sessionUser = signService.userLoginCon(sign);
        model.addAttribute("sessionUser",sessionUser);
        return "index";
    }









}
