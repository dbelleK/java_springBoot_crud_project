package com.example.crud.repository;

import com.example.crud.domain.Sign;
import org.springframework.stereotype.Repository;

@Repository
public interface MypageRepository {

    // 1. 회원가입으로 마이페이지 연결 (정보 넘기고 회원가입과 마이페이지 연결해야하니 리턴)
    Sign userMyPageCon(Sign sign);

    // 1. 마이페이지 업데이트 시 회원가입도 업데이트 연결 (update set where -> 정보만 업데이트하는 거니 리턴x 이미 4에서 연결함)
    void userMyPageUpdate(Sign sign);
}
