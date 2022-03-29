package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

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

        return new ModelAndView("user/signUp");
    }

    //http://localhost8082/login
    @RequestMapping(path = "login")
    public ModelAndView login(Principal principal, @RequestParam(value = "error", defaultValue = "false") Boolean error) {
            if (error) {
                return new ModelAndView("user/login").
                        addObject("error", error);
            } else {
                if (!ObjectUtils.isEmpty(principal)) {
                    return new ModelAndView("index");
                }
                return new ModelAndView("user/login");
            }
    }

    //http://localhost8082/mypageMain
    @RequestMapping(path = "mypageInfo")
    public ModelAndView mypageInfo() {

        return new ModelAndView("mypage/mypageInfo");
    }

    //http://localhost8082/mypageWhislist
    @RequestMapping(path = "mypageWhislist")
    public ModelAndView mypageWhislist() {

        return new ModelAndView("mypage/mypageWhislist");
    }
}


