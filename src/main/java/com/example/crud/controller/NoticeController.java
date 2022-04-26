package com.example.crud.controller;

import com.example.crud.domain.CommonNotice;
import com.example.crud.domain.Content;
import com.example.crud.domain.Reviews;
import com.example.crud.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //글 작성
    @PostMapping("/writePro")
    public String writePro(CommonNotice commonNotice){

        if(commonNotice.getCommonContentIdx() != 0){
            // update
            noticeService.updateQuestions(commonNotice);

        }else {
            // insert
            noticeService.writeUserInfo(commonNotice);
        }

        return "redirect:/questions";
    }

    //삭제하기
    @GetMapping("/deletePro")
    public String deletePro(int commonContentIdx){
        noticeService.deleteQuestions(commonContentIdx);
        return "redirect:/questions";
    }


    @PostMapping("/reviewPro")
    public String reviewPro(CommonNotice commonNotice){

        if(commonNotice.getCommonContentIdx() != 0){
            // update
            noticeService.updateReview(commonNotice);

        }else {
            // insert
            noticeService.reviewsUserInfo(commonNotice);
        }

        return "redirect:/review";
    }

    @GetMapping("deletePro2")
    public String deletePro2(int commonContentIdx){
        noticeService.deleteReview(commonContentIdx);
        return "redirect:/review";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //쓴 글 내용 표시하기
    //http://localhost8082/noticeIssues
    @RequestMapping(path = "issues")
    public ModelAndView issues(Content content, Model model) {
        // 등록된 게시판 불러오기
        List<Content> contents= noticeService.appearNoticeInfo();
        // 모델에 담기
        model.addAttribute("contents", contents);

        return new ModelAndView("/notice/issues");
    }

    //http://localhost8082/noticeIssues
    @RequestMapping(path = "questions")
    public ModelAndView questions(Content content, Model model) {
        // 등록된 게시판 불러오기
        List<Content> contents= noticeService.appearNoticeInfo();
        // 모델에 담기
        model.addAttribute("contents", contents);

        return new ModelAndView("/notice/questions");
    }

    //http://localhost8082/noticeIssues
    @RequestMapping(path = "review")
    public ModelAndView review(Model model) {
        // 등록된 게시판 불러오기
        List<Reviews> reviews= noticeService.appearNoticeReviewsInfo();
        // 모델에 담기
        model.addAttribute("reviews", reviews);

        return new ModelAndView("/notice/review");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //idx연결 - idx로 쓰여진 글 누르면 그 해당글 보이기
    //http://localhost8082/write
    @RequestMapping(path = "questions-write-form")
    public ModelAndView questionsWriteForm(int contentIdx) {

        Content contents= noticeService.getContentInfo(contentIdx);
        CommonNotice commonNotice = new CommonNotice();
        if (contents != null){
            commonNotice.setCommonContentIdx(contents.getContentIdx());
            commonNotice.setCommonNoticeSubject(contents.getContentSubject());
            commonNotice.setCommonNoticeText(contents.getContentText());
        }
        return new ModelAndView("/notice/questions_write_form")
                .addObject("commonNotice",commonNotice);
    }

    //http://localhost8082/write
    @RequestMapping(path = "review-write-form")
    public ModelAndView reviewWriteForm(int reviewsIdx) {

        Reviews reviews= noticeService.getReviewsInfo(reviewsIdx);
        CommonNotice commonNotice = new CommonNotice();
        if (reviews != null){
            commonNotice.setCommonContentIdx(reviews.getReviewsIdx());
            commonNotice.setCommonNoticeSubject(reviews.getReviewsSubject());
            commonNotice.setCommonNoticeText(reviews.getReviewsText());
        }
        return new ModelAndView("/notice/review_write_form")
                .addObject("commonNotice",commonNotice);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //새로운 글 작성 뷰 보이기
    @RequestMapping(path = "write-base")
    public ModelAndView writeBase() {
        return new ModelAndView("notice/write_base");
    }


    @RequestMapping(path = "questions-write-form-new")
    public ModelAndView questionsWriteForm() {

        return new ModelAndView("/notice/questions_write_form");

    }

    @RequestMapping(path = "review-write-form-new")
    public ModelAndView reviewsWriteForm() {

        return new ModelAndView("/notice/review_write_form");

    }





}
