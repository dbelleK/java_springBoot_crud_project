package com.example.crud.controller;

import com.example.crud.domain.*;
import com.example.crud.repository.NoticeRepository;
import com.example.crud.service.NoticeService;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeRepository noticeRepository;

    //http://localhost8082
    @RequestMapping(path = {""})
    public ModelAndView index(Principal principal, @RequestParam(value = "logout", defaultValue = "false") Boolean logout) {

        //문의하기
        /*page:1 -> page가 1페이지인것 출력, page:2 -> page가 2페이지인것*/
        List<Content> contents = noticeService.appearNoticeInfo(2);

        //리뷰하기
        PageInfo pageInfo = new PageInfo(1, 7);
        pageInfo.setItemCountTatal(noticeRepository.getPageCountReview());

        List<Reviews> reviews = noticeService.appearNoticeReviewsInfo(pageInfo);

        return new ModelAndView("index")
                .addObject("contents",contents)
                .addObject("reviews",reviews);

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




        //http://localhost8082/mypageInfo
    @RequestMapping(path = "mypageInfo")
    public ModelAndView mypageInfo(@RequestParam(value = "error", defaultValue = "false") Boolean error) {

        if (error) { //error가 true일 때 : 로그인이 되지 않았을 때
            return new ModelAndView("mypage/mypageInfo") // 다시 login페이지를 보여준다
                    .addObject("error", error);
        } else {
            return new ModelAndView("mypage/mypageInfo"); //그렇지 않으면(로그인이 되지 않으면) login 페이지를 보여준다
        }
    }

    //http://localhost8082/mypageWishList
    @RequestMapping(path = "mypageWishList")
    public ModelAndView mypageWishList() {

        return new ModelAndView("mypage/mypageWishList");
    }

  /*  //http://localhost8082/noticeIssues
    @RequestMapping(path = "issues")
    public ModelAndView issues(Content content, Model model) {
        // 등록된 게시판 불러오기
        List<Content> contents= noticeService.appearNoticeInfo();
        // 모델에 담기
        model.addAttribute("contents", contents);

        return new ModelAndView("notice/issues");
    }

    //http://localhost8082/noticeIssues
    @RequestMapping(path = "questions")
    public ModelAndView questions(Content content, Model model) {
        // 등록된 게시판 불러오기
        List<Content> contents= noticeService.appearNoticeInfo();
        // 모델에 담기
        model.addAttribute("contents", contents);

        return new ModelAndView("notice/questions");
    }

    //http://localhost8082/noticeIssues
    @RequestMapping(path = "review")
    public ModelAndView review(Model model) {
        // 등록된 게시판 불러오기
        List<Reviews> reviews= noticeService.appearNoticeReviewsInfo();
        // 모델에 담기
        model.addAttribute("reviews", reviews);

        return new ModelAndView("notice/review");
    }
    //http://localhost8082/write
    @RequestMapping(path = "questions-write-form")
    public ModelAndView questionsWriteForm(int contentIdx) {

        Content contents= noticeService.getContentInfo(contentIdx);
        CommonNotice commonNotice = new CommonNotice();
        if (contents != null){
            commonNotice.setCommonNoticeSubject(contents.getContentSubject());
            commonNotice.setCommonNoticeText(contents.getContentText());
        }
        return new ModelAndView("notice/questions_write_form")
                .addObject("commonNotice",commonNotice);
    }

    //http://localhost8082/write
    @RequestMapping(path = "review-write-form")
    public ModelAndView reviewWriteForm(int reviewsIdx) {

        Content contents= noticeService.getContentInfo(reviewsIdx);
        CommonNotice commonNotice = new CommonNotice();
        if (contents != null){
            commonNotice.setCommonNoticeSubject(contents.getContentSubject());
            commonNotice.setCommonNoticeText(contents.getContentText());
        }
        return new ModelAndView("notice/review_write_form")
                .addObject("commonNotice",commonNotice);
    }*/
}


