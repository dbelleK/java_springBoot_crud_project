package com.example.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAuthority extends BaseTimeEntity implements GrantedAuthority {

    @Id
    private Long userId;

    @Id
    private String authority;

}