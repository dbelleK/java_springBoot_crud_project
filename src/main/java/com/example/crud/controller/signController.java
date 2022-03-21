package com.example.crud.controller;

import com.example.crud.domain.Sign;
import com.example.crud.service.SignService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RequiredArgsConstructor
@Controller
public class signController {

    private final SignService signService;

    @PostMapping("/signUpPro")
    public String signUpPro(Sign sign){
        signService.checkUserId(sign.getId());
        signService.addUserInfo(sign);
        return "sign/login";
    }







}
