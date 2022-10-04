package com.coder.service.controller;

import com.coder.service.domain.dto.UserDTO;
import com.coder.service.service.UserSerivce;
import com.coder.service.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "认证接口")
@RestController
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public ResponseUtils login(@RequestBody UserDTO userDTO) {
        return userSerivce.login(userDTO);
    }

    @ApiOperation("注册接口")
    @PostMapping("/register")
    public ResponseUtils register(@RequestBody UserDTO userDTO) {
        return userSerivce.register(userDTO);
    }
}
