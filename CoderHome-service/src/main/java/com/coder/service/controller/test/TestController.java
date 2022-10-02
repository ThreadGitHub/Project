package com.coder.service.controller.test;

import com.coder.service.domain.entity.User;
import com.coder.service.service.UserSerivce;
import com.coder.service.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private UserSerivce userSerivce;

    @ApiOperation("获取token")
    @GetMapping("/getToken")
    public String getToken(String subject, Integer time) {
        return jwtUtils.createJWT(subject, time);
    }

    @ApiOperation("校验token")
    @GetMapping("/checkToken")
    public boolean checkToken(String token) {
        return jwtUtils.verify(token);
    }

    @ApiOperation("查用户")
    @GetMapping("/users")
    public List<User> listUser() {
        return userSerivce.list();
    }
}
