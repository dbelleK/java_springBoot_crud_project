package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    //http://localhost8082
    @RequestMapping(path = {""})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    //http://localhost8082/signUp
    @RequestMapping(path = "signUp")
    public ModelAndView signUp() {

        return new ModelAndView("sign/signUp");
    }
}


