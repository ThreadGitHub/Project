package com.coder.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.dto.UserDTO;
import com.coder.service.domain.entity.User;
import com.coder.service.mapper.UserMapper;
import com.coder.service.service.UserSerivce;
import com.coder.service.utils.ResponseUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public boolean hasUserExsit(String userName) {
        User user = getUserByName(userName);
        if (Objects.isNull(user)) {
            return false;
        }
        return true;
    }

    @Override
    public User getUserByName(String userName) {
        return this.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, userName));
    }

    @Override
    public ResponseUtils login(UserDTO user) {
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(userToken);
            System.out.println(authenticate);
        }catch (Exception e) {
            String message = e.getMessage();
            return ResponseUtils.error(message);
        }
       return ResponseUtils.success("ok");
    }
}
