package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class Reviews {

    private int reviewsIdx; //글번호
    private String reviewsSubject; //글제목
    private String reviewsText; //글내용
    private String reviewsApply; //리뷰답변

    private MultipartFile reviewsUploadFile; //파일
    private String reviewsFile;

    private int reviewsWriterIdx; //글쓴사람번호
    private int reviewsBoardIdx; //글쓴게시판번호 - Notice클래스 boardIdx 연결
    private String reviewsDate; //글쓴날짜
}


