package com.coder.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.dto.UserDTO;
import com.coder.service.domain.entity.User;
import com.coder.service.domain.entity.UserToken;
import com.coder.service.mapper.UserMapper;
import com.coder.service.service.UserSerivce;
import com.coder.service.service.UserTokenService;
import com.coder.service.utils.JwtUtils;
import com.coder.service.utils.ResponseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private UserTokenService userTokenService;
    @Resource
    private UserSerivce userSerivce;
    @Resource
    private PasswordEncoder passwordEncoder;

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
        }catch (Exception e) {
            String message = e.getMessage();
            return ResponseUtils.error(message);
        }
        String jwt = jwtUtils.createJWT(user.getUserName(), 30);
        UserToken token = new UserToken();
        token.setToken(jwt);
        token.setUserName(user.getUserName());
        boolean save = userTokenService.saveOrUpdate(token, new LambdaUpdateWrapper<UserToken>().eq(UserToken::getUserName, user.getUserName()));
        if (save){
            return ResponseUtils.success(token);
        } else {
            return ResponseUtils.error("用户登录失败,保存token失败");
        }
    }

    @Override
    public ResponseUtils register(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        userSerivce.save(userEntity);
        return ResponseUtils.ok();
    }
}
