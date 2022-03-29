package com.example.crud.controller;

import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private UserService userService;

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
            if (error) { //error가 true일 때 : 로그인이 되지 않았을 때
                return new ModelAndView("user/login"). // 다시 login페이지를 보여준다
                        addObject("error", error);
            } else {

                if (!ObjectUtils.isEmpty(principal)) { //로그인이 되었을 때
                    return new ModelAndView("index"); //index페이지를 보여준다
                }
                return new ModelAndView("user/login"); //그렇지 않으면(로그인이 되지 않으면) login 페이지를 보여준다
            }
    }

    @RequestMapping(path = "logout")
    public String logout() {
        userService.logout();
        return "redirect:/"; //페이지를 리턴해주는 곳인데 페이지를 보여주는 대신 redirect로 바로 루트(index)로 간다
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


