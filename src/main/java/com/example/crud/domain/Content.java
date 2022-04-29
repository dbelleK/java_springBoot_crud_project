package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class Content {


    private int contentIdx; //글번호
    private String contentSubject; //글제목
    private String contentText; //글내용

    private String contentFile;

    private int contentWriterIdx; //글쓴사람번호
    private int contentBoardIdx; //글쓴게시판번호 - Notice클래스 boardIdx 연결
    private String contentDate; //글쓴날짜
}
