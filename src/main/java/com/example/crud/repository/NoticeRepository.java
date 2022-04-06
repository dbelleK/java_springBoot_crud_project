package com.example.crud.repository;

import com.example.crud.domain.Content;
import com.example.crud.domain.Reviews;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository {

    /////////문의하기//////////
    //글 작성(제목,내용)(insert)
    void writeUserInfo(Content content);

    //글 표시(select)
    List<Content> appearNoticeInfo();

    /////////리뷰하기//////////
    //글 작성(제목,내용)(insert)
    void reviewsUserInfo(Reviews reviews);

    //글 표시(select)
    List<Reviews> appearNoticeReviewsInfo();

    //contentIdx
    Content getContentInfo(int contentIdx);
}
