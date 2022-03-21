package com.example.crud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sign {

    private String id;
    private String pass;
    private String passCheck;
    private String email;
    private String inviteId;

}
