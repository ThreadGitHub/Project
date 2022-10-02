package com.coder.service.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserAuth {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
