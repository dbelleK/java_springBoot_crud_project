package com.example.crud.service;

import com.example.crud.common.UserUtils;
import com.example.crud.domain.Sign;
import com.example.crud.repository.MypageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MypageRepository mypageRepository;

    private final PasswordEncoder passwordEncoder;


//    // 1. 회원가입으로 마이페이지 연결
//    public String userMyPageCon(Sign sign){
//
//        Sign mypageInfo =mypageRepository.userMyPageCon(sign);
//        return
//
//    }

    //2.마이페이지 업데이트
    public boolean userMyPageUpdate(Sign loginInfo) {

        //회원 정보 불러오기
        Sign memberUpdate = UserUtils.getUser();

        //비밀번호 암호화가된 비번이 맞으면
        if (passwordEncoder.matches(loginInfo.getPass(), memberUpdate.getPass())) {

            memberUpdate.setId(loginInfo.getId());
            memberUpdate.setAddress(loginInfo.getAddress());
            memberUpdate.setNewPass(loginInfo.getNewPass());
            memberUpdate.setNewPassCheck(loginInfo.getNewPassCheck());

            mypageRepository.userMyPageUpdate(memberUpdate);
            return true;

        } else {
            //이전 pass가 틀리면 변경
            return false;
        }
    }

}

