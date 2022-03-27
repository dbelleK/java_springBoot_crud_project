package com.example.crud.controller.api;

import com.example.crud.domain.MailDto;
import com.example.crud.domain.Sign;
import com.example.crud.repository.MypageRepository;
import com.example.crud.repository.SignRepository;
import com.example.crud.service.api.LoginApiService;
import com.example.crud.service.api.MailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.apache.commons.lang.RandomStringUtils;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class findPasswordApiController {

    @Autowired
    private SignRepository signRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private MypageRepository mypageRepository;



//    @Autowired
//    private
//    PasswordEncoder passwordEncoder;

    @PostMapping(value="/email/sendEmailProcess")
    @ResponseBody
//    public boolean findPasswordByEmail(String email) throws IOException, MessagingException {
//    public boolean findPasswordByEmail(Sign signsss) throws IOException, MessagingException {
    public boolean findPasswordByEmail(MailDto mailDto) throws IOException, MessagingException {

        //db에 저장되어 잇는 이메일을 찾아 그 이메일이 있으면 그 이메일에 전송 해야하니까 getUserInfo 사용
        //db에 저장되어 있는 이메일 , 아이디 등등이 들어있을테니까
        Sign signs = signRepository.getUserInfo(mailDto.getEmail());

        if (signs != null){
            // 이메일 전송
            Sign sign = new Sign();
            String generatedString = RandomStringUtils.randomAlphanumeric(10);
//            sign.setPass(passwordEncoder.encode(generatedString));
            sign.setPass(generatedString);

            //MypageRepository userMyPageUpdate()메소드에 id,pass,address를 변경시켜준다고 하여 이메소드를 이용하기 위해
            //따라서 이들은 새로운 id,address,idx가 아닌 같은 값이다
            sign.setId(signs.getId());
            sign.setAddress(signs.getAddress());
            sign.setIdx(signs.getIdx());

            //db에 빈객체를 넘길 수 없으니 userMyPageUpdate()를 이용하여 db에 저장해야한다
            mypageRepository.userMyPageUpdate(sign);

            mailDto.setSubject("[dbellemall] 비밀번호 찾기 이메일 입니다.");
            mailDto.setContents("초기화 비밀번호는 : " + generatedString + " 입니다.");

            mailService.sendMail(mailDto);

        return true;
        }
        return false;
    }
}
