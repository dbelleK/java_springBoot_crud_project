package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LayoutController {

    //http://localhost8082/header
    @RequestMapping(path = "header")
    public ModelAndView header() {

        return new ModelAndView("header");
    }
}
