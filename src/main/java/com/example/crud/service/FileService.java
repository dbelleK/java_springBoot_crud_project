package com.example.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final ServletContext servletContext;

    public String fileUpload(MultipartFile file) throws Exception {

        String projectPath = servletContext.getRealPath("/resources/static/"); //저장할 경로 지정

        UUID uuid = UUID.randomUUID(); //파일이름에 붙일 랜덤 이름 생성
        String fileName = uuid + "_" + file.getOriginalFilename(); //랜덤이름_파일이름

        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);//저장하는 로직(저장됨)

        String filePath = "resources/static/"+fileName; //저장된 위치
        return filePath;
    }
}