package com.coder.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {
    @PreAuthorize("hasAuthority('system:homepage')")
    @GetMapping("/hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println();
        return "hello "+ authentication.getName() +" ! ";
    }

    @PreAuthorize("hasAuthority('system:manager')")
    @ApiOperation("管理员授权")
    @GetMapping("admin")
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasAuthority('system:homepage')")
    @ApiOperation("普通用户户授权")
    @GetMapping("/user")
    public String user() {
        return "user";
    }
}