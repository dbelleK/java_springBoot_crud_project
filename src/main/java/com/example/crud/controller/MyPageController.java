package com.example.crud.controller;

import com.example.crud.domain.Sign;
import com.example.crud.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyPageController {

    @Autowired
    private MypageService mypageService;

    @PostMapping("/mypageInfoPro")
    public String mypageInfoPro(Model model, Sign sign){
        boolean status = mypageService.userMyPageUpdate(sign);

        if (status){
            // 정보 업데이트 성공
            return "redirect:/mypageInfo";

        }else {
            // 정보 업데이트 실패
            return "redirect:/mypageInfo?error="+true;
        }
    }
}
