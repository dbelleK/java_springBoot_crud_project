package com.example.crud.service;

import com.example.crud.domain.CommonNotice;
import com.example.crud.domain.Content;
import com.example.crud.domain.Reviews;
import com.example.crud.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

     // 1. 글 작성(제목,내용)(insert)
    public void writeUserInfo(CommonNotice commonNotice){

        Content content = new Content();
        //공통제목에서 가져와서 content에 저장
        content.setContentSubject(commonNotice.getCommonNoticeSubject());
        content.setContentText(commonNotice.getCommonNoticeText());

        noticeRepository.writeUserInfo(content);
    }


    //2. 글내용 표시(select)
    public List<Content> appearNoticeInfo(){
        return noticeRepository.appearNoticeInfo();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    // 1. 글 작성(제목,내용)(insert)
    public void reviewsUserInfo(CommonNotice commonNotice){

        Reviews reviews = new Reviews();
        reviews.setReviewsSubject(commonNotice.getCommonNoticeSubject());
        reviews.setReviewsText(commonNotice.getCommonNoticeText());

        noticeRepository.reviewsUserInfo(reviews);
    }


    //2. 글내용 표시(select)
    public List<Reviews> appearNoticeReviewsInfo(){
        return noticeRepository.appearNoticeReviewsInfo();
    }


    //contentIdx
    public Content getContentInfo(int contentIdx) {
        return noticeRepository.getContentInfo(contentIdx);
    }
}

