package com.example.crud.controller;

import com.example.crud.domain.Sign;
import com.example.crud.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @Autowired
    private MypageService mypageService;

//    @GetMapping("/mypageInfoPro")
//    public String mypageInfoPro(Sign sign){
//        mypageService.userMyPageUpdate(sign);
//        return "index";
//    }
//}
