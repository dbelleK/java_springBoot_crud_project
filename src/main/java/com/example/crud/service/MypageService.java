package com.example.crud.service;

import com.example.crud.domain.Sign;
import com.example.crud.repository.MypageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    //2. 마이페이지 업데이트
    public void userMyPageUpdate(HttpServletRequest request){

        Sign sign = new Sign();
        sign =(Sign)request.getSession().getAttribute("user");

        //이전 pass가 맞으면 새로운 newPass와 newPassCheck 변경
        if(request.getParameter("pass").equals(sign.getPass())) {
            sign.setId(request.getParameter("id"));
            sign.setAddress(request.getParameter("address"));
            sign.setNewPass(request.getParameter("newPass"));
            sign.setNewPasscheck(request.getParameter("newPassCheck"));

            mypageRepository.userMyPageUpdate(sign);

        }
        //이전 pass가 틀리면 변경 못되게
        else if (passwordEncoder.matches(request.getParameter("pass"), sign.getPass())){
            sign.setPass(passwordEncoder.encode(request.getParameter("newPass")));
            mypageRepository.userMyPageUpdate(sign);


        }else {
            mypageRepository.userMyPageUpdate(sign);
        }

    }
}
