package com.example.crud.repository;

import com.example.crud.domain.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository {

    //글 작성(제목,내용)(insert)
    void writeUserInfo(Content content);

    //글 표시(select)
    List<Content> appearNoticeInfo();
}
