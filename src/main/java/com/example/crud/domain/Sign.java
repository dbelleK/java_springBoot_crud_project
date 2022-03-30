package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sign {

    private int idx;
    private String id;
    private String email;
    private String pass;
    private String passCheck;
    private String address;
    private String birthday;
    private String kakaoId;
    private String profile;

    private String newPass;
    private String newPassCheck;



}
