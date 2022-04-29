package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class CommonNotice {

    private int commonContentIdx;

    private String commonNoticeSubject; //글제목
    private String commonNoticeText; //글내용

    private String commonNoticeApply; //리뷰답변

    private String commonNoticeFile;

    private int commonNoticeWriterIdx; //글쓴사람번호
    private int commonNoticeBoardIdx; //글쓴게시판번호 - Notice클래스 boardIdx 연결
    private String commonNoticeDate; //글쓴날짜
}



