package com.coder.service.domain.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}