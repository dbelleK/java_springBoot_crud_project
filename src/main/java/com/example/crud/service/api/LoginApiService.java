package com.example.crud.service.api;

import com.example.crud.domain.Sign;
import com.example.crud.repository.SignRepository;
import com.example.crud.repository.api.LoginApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginApiService {

    @Autowired
    private LoginApiRepository loginApiRepository;

    @Autowired
    private SignRepository signRepository;

//    // 1. 카카오로그인 가입시키기 insert
//    public void joinUserByKakao(Sign sign){
//        loginApiRepository.joinUserByKakao(sign);
//    }

    // 2. 이메일로 가입한 사람과 카카오아이디로 가입한 사람이 같은지 아닌지 중복체크, select로 리턴

    //todo
    // 1) 가입한 사람이 있는지 체크
    // (이메일로 가입하고 카카오로그인으로 가입시킨사람을 연동시키기 위해서 따로 둘 수 없으니까)
    // 2) 이메일로 가입했으면 카카오로그인만 회원가입 시킴
    // 3) 이메일로 가입도 안된사람이라면 이메일가입과 카카오로그인 회원가입 둘다 시킴



    public Sign checkUserByKakao(Sign kakaoInfo){

        Sign checkInfo =signRepository.getUserInfo(kakaoInfo.getEmail()); //getUserInfo 리턴타입이 Sign

        if(checkInfo == null){ //이메일이 없는 사람 //즉,가입한 사람이 없으면 카카오아이디와 이메일 가지고 회원가입시킴

            Sign newUserInfo = new Sign();
            newUserInfo.setKakaoId(kakaoInfo.getKakaoId());
            newUserInfo.setEmail(kakaoInfo.getEmail());

            newUserInfo.setProfile(kakaoInfo.getProfile());
            newUserInfo.setBirthday(kakaoInfo.getBirthday());
            loginApiRepository.joinUserByKakao(newUserInfo); //insert쿼리문 이용
            return newUserInfo;

        }else{

            //이메일로 가입한 사람이 있으면 카카오아이디만 가지고 와서 회원가입 시킴

            if (checkInfo.getKakaoId() == null){
                // 카카오 아이디 업데이트
                checkInfo.setKakaoId(kakaoInfo.getKakaoId());

                checkInfo.setProfile(kakaoInfo.getProfile());
                checkInfo.setBirthday(kakaoInfo.getProfile());

                loginApiRepository.updateUserByKakao(checkInfo);
                return checkInfo;
            }else {
                // 카카오 아이디가 이미 존재하기 때문에 로그인만 진행
                return checkInfo;
            }
        }
    }
}
