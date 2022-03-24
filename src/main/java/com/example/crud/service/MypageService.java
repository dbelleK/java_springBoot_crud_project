package com.example.crud.service;

import com.example.crud.domain.Sign;
import com.example.crud.repository.MypageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MypageRepository mypageRepository;

    // 1. 회원가입으로 마이페이지 연결
//    public String userMyPageCon(Sign sign){
//
//        Sign mypageInfo =mypageRepository.userMyPageCon(sign);
//        return
//
//    }
}
