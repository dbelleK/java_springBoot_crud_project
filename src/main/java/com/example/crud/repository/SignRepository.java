package com.example.crud.repository;

import com.example.crud.domain.Sign;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository {

    // 1. 회원가입 (insert into -> 넣기만 하는 거니 리턴x)
    void addUserInfo(Sign sign);

    // 2. 아이디 중복체크 (아이디 중복해보고 중복인지 아닌지 확인해야하니 리턴)
    String checkUserId(String id);

    // 3. 회원가입으로 로그인 연결 (정보 넘기고 회원가입과 로그인이 일치하는지 아는지 확인해야하니 리턴)
    Sign userLoginCon(Sign sign);

//    // 4. 회원가입으로 마이페이지 연결 (정보 넘기고 회원가입과 마이페이지 연결해야하니 리턴)
//    Sign userMyPageCon(Sign sign);
//
//    // 5. 마이페이지 업데이트 시 회원가입도 업데이트 연결 (update set where -> 정보만 업데이트하는 거니 리턴x 이미 4에서 연결함)
//    void userMyPageUpdate(Sign sign);



}
