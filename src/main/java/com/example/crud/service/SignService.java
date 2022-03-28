package com.example.crud.service;

import com.example.crud.domain.Sign;
import com.example.crud.domain.UserAuthority;
import com.example.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@RequiredArgsConstructor
@Service
public class SignService {

    //서비스에서는 레퍼지토리에서 만든 리턴타입을 받아주는 곳

    // 뷰->컨트롤러(login)->서비스(새로운메서드:어떠한 로직을 위해)->레퍼지토리로가서(로직에서 만든 데이터를 저장하기위해 만들어)
    //  ->xml(실제로 데이터베이스에 저장하기 위핸 sql)
    // 여기서 반대방향으로 가는 경우는 리턴타입이 있을 경우

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Resource(name = "loginBean")
    private Sign loginBean;

    // 1. 회원가입 (insert into -> 넣기만 하는 거니 리턴x)
    public void joinUserInfo(Sign sign) {

        Sign user = sign;
        user.setPass(passwordEncoder.encode(sign.getPass())); //회원가입시 비밀번호 암호화시켜줘야함
        userRepository.joinUserInfo(user);

        //UserAuthority클래스의 userId와 authority 연결 -> 회원가입시 동시에 권한 설정도 해주어야하기에
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setUserId((long)sign.getIdx());
        userAuthority.setAuthority("ROLE_USER");
        userRepository.insertAuthority(userAuthority);
    }

    // 2. 이메일 중복체크 (이메일 중복해보고 중복인지 아닌지 확인->회원가입시 같은 이메일 사용자가 있으면 안되니까)
    public boolean checkUserId(Sign sign) {

        Sign checkUser = userRepository.getUserInfo(sign.getEmail());

        // email이 null이면 즉, 같은 이메일이 없으면 true
        if (checkUser.getEmail() == null) {
            return true;
        } else {
            return false;
        }
    }

    // 3. 회원가입으로 로그인 연결
    public Sign userLoginCon(String email) {
        Sign loginSuccess = userRepository.getUserInfo(email);

        //email이 있으면 이메일을 가져와서 세션스코프 loginBean에 이메일을 저장시켜 전달한다.
        if (loginSuccess != null) {
                loginBean.setEmail(loginSuccess.getEmail());
        }
         return loginBean;
    }

}