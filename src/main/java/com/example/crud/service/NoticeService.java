package com.example.crud.service;

import com.example.crud.domain.CommonNotice;
import com.example.crud.domain.Content;
import com.example.crud.domain.Page;
import com.example.crud.domain.Reviews;
import com.example.crud.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private int contentPageCnt = 10;  //글번호 10개씩
    private int paginationcnt = 10; //버튼 10개씩

    private final NoticeRepository noticeRepository;

     //문의하기
     // 1. 글 작성(제목,내용)(insert)
    public void writeUserInfo(CommonNotice commonNotice){

        Content content = new Content();
        //공통제목에서 가져와서 content에 저장
        content.setContentSubject(commonNotice.getCommonNoticeSubject());
        content.setContentText(commonNotice.getCommonNoticeText());

        noticeRepository.writeUserInfo(content);
    }

    //2. 글내용 표시(select)
    public List<Content> appearNoticeInfo(int page){

        int start = (page-1)*contentPageCnt; //(2-1)*10=10 / (3-1)*10=20
        RowBounds rowBounds=new RowBounds(start,contentPageCnt); //0부터 시작해서 10개씩

        List<Content> boardAllList = noticeRepository.appearNoticeInfo(rowBounds);
        return boardAllList;
    }


    //3. 수정하기
    public void updateQuestions(CommonNotice commonNotice){
        noticeRepository.updateQuestions(commonNotice);
    }

    //4. 삭제하기
    public void deleteQuestions(int commonContentIdx){
        noticeRepository.deleteQuestions(commonContentIdx);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////


    //리뷰하기
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

    //3. 수정하기
    public void updateReview(CommonNotice commonNotice){
        noticeRepository.updateReview(commonNotice);
    }

    //4. 삭제하기
    public void deleteReview(int commonContentIdx){
        noticeRepository.deleteReview(commonContentIdx);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////

    //contentIdx
    public Content getContentInfo(int contentIdx) {
        return noticeRepository.getContentInfo(contentIdx);
    }

    //contentIdx
    public Reviews getReviewsInfo(int reviewsIdx) {
        return noticeRepository.getReviewsInfo(reviewsIdx);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    //페이지 수
    // currentPage:현재 페이지 번호
    public Page getPageCount(int currentPage){

        //전체 글의 갯수
        int contentsCnt = noticeRepository.getPageCount();
        Page page = new Page(contentsCnt, currentPage, contentPageCnt, paginationcnt);
        return page;

    }
}

