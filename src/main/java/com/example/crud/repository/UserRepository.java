package com.example.crud.repository;

import com.example.crud.domain.Sign;
import com.example.crud.domain.UserAuthority;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    //1.회원가입 insert
    void joinUserInfo(Sign sign);

    //2.회원가입 된 db 확인하여(같은 이메일이 있는지 중복확인) 로그인 연결  //이메일로 가입한 사람과 카카오아이디로 가입한 사람이 같은지 아닌지 중복체크
    Sign getUserInfo(String email);  /*(Stirng emails)해도됨 객체명은 마음대로*/

    //3. 이메일로 가입한 사람만 있는 경우 카카오아이디 업데이트
    void updateUserByKakao(Sign sign);

    //4. 권한 설정 insert
    void insertAuthority(UserAuthority userAuthority);

    //5. 등록된 권한을 가져온다.
    @Select("SELECT * FROM taehan.USER_AUTHORITY where user_id = #{asd}")
    List<UserAuthority> findAuthorityById(@Param("asd") Long ids); //ids=변수 asd=변수의 값


}
