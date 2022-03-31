package com.example.crud.controller;

import com.example.crud.domain.Content;
import com.example.crud.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/writePro")
    public String writePro(Content content, Model model){

        contentService.writeUserInfo(content);


        return "redirect:/issues";
    }

}
