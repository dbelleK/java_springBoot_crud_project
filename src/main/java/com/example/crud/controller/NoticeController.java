package com.example.crud.controller;

import com.example.crud.domain.CommonNotice;
import com.example.crud.domain.Content;
import com.example.crud.domain.Reviews;
import com.example.crud.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @PostMapping("/writePro")
    public String writePro(CommonNotice commonNotice){

        noticeService.writeUserInfo(commonNotice);


        return "redirect:/issues";
    }

    @PostMapping("/reviewPro")
    public String reviewPro(CommonNotice commonNotice){

        noticeService.reviewsUserInfo(commonNotice);


        return "redirect:/review";
    }
}
