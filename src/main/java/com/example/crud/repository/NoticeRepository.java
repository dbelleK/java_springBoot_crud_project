package com.example.crud.repository;

import com.example.crud.domain.CommonNotice;
import com.example.crud.domain.Content;
import com.example.crud.domain.Reviews;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository {


    /////////--------------문의하기-------------//////////
    //글 작성(제목,내용)(insert)
    void writeUserInfo(Content content);

    //글 표시(select)
    List<Content> appearNoticeInfo();

    //수정하기
    void updateQuestions(CommonNotice commonNotice);

    //삭제하기
    void deleteQuestions(int commonContentIdx);


    /////////--------------리뷰하기--------------//////////
    //글 작성(제목,내용)(insert)
    void reviewsUserInfo(Reviews reviews);

    //글 표시(select)
    List<Reviews> appearNoticeReviewsInfo();

    //수정하기
    void updateReview(CommonNotice commonNotice);

    //삭제하기
    void deleteReview(int commonContentIdx);


    /////////////////////////////
    //contentIdx
    Content getContentInfo(int contentIdx);

    //reviewsIdx
    Reviews getReviewsInfo(int reviewsIdx);


}
