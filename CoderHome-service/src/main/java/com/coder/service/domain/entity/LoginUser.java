package com.coder.service.domain.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser implements Serializable {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
