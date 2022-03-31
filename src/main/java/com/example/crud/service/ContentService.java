package com.example.crud.service;

import com.example.crud.domain.Content;
import com.example.crud.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

     // 1. 글 작성(제목,내용)(insert)
    public void writeUserInfo(Content content){

        Content contentIssues =new Content();

        contentIssues.setContentSubject(content.getContentSubject());
        contentIssues.setContentText(content.getContentText());
        contentIssues.setContentFile(content.getContentFile());
        contentIssues.setContentDate(content.getContentDate());

        contentRepository.writeUserInfo(content);
    }


    //2. 글내용 표시(select)
    public List<Content> appearNoticeInfo(){
        return contentRepository.appearNoticeInfo();
    }
}
