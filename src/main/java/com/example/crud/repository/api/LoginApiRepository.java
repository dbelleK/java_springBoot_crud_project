package com.example.crud.repository.api;

import com.example.crud.domain.Sign;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginApiRepository {

    // 1. 카카오로그인 가입시키기 insert
    void joinUserByKakao(Sign sign);

    // 2. 이메일로 가입한 사람과 카카오아이디로 가입한 사람이 같은지 아닌지 중복체크, select로 리턴
    Sign checkUserByKakao(String email);

    // 3. 이메일로 가입한 사람만 있는 경우 카카오아이디 업데이트
    void updateUserByKakao(Sign sign);

    //------------------------------------------------------------------------------------
    // 3. 카카오 아이디와 카카오 이메일,생일을 보여줘야함 select ((보류))

    // 4. 권한체크 나중..


}
