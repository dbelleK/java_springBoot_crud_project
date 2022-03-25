package com.example.crud.service;

import com.example.crud.domain.Sign;
import com.example.crud.repository.SignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Service
public class SignService {

    //서비스에서는 레퍼지토리에서 만든 리턴타입을 받아주는 곳

    // 뷰->컨트롤러(login)->서비스(새로운메서드:어떠한 로직을 위해)->레퍼지토리로가서(로직에서 만든 데이터를 저장하기위해 만들어)
    //  ->xml(실제로 데이터베이스에 저장하기 위핸 sql)
    // 여기서 반대방향으로 가는 경우는 리턴타입이 있을 경우

    private final SignRepository signRepository;

    @Resource(name = "loginBean")
    private Sign loginBean;

    // 1. 회원가입 (insert into -> 넣기만 하는 거니 리턴x)
    public void addUserInfo(Sign sign) {

        signRepository.addUserInfo(sign);
    }

    // 2. 아이디 중복체크 (아이디 중복해보고 중복인지 아닌지 확인해야하니 리턴)
    public boolean checkUserId(String id) {

        Sign sign = new Sign();
        sign.setId(id);

        Sign checkkUser = signRepository.getUserInfo(sign.getEmail());

        if (checkkUser.getId() == null) {
            return true;
        } else {
            return false;
        }
    }

    // 3. 회원가입으로 로그인 연결
    public Sign userLoginCon(String email) {
        Sign loginSuccess = signRepository.getUserInfo(email);

        //아이디 비밀번호가 있으면
        if (loginSuccess != null) {
                loginBean.setEmail(loginSuccess.getEmail());
//                loginBean.setPass(loginSuccess.getPass());
        }
         return loginBean;
    }

}