package com.coder.service.service.impl;

import com.coder.service.domain.entity.LoginUser;
import com.coder.service.domain.entity.User;
import com.coder.service.service.UserSerivce;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserSerivce userSerivce;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userSerivce.getUserByName(userName);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserDetailImpl userDetail = new UserDetailImpl();
        userDetail.setLoginUser(LoginUser.builder().userName(user.getUserName()).password(user.getPassword()).build());
        return userDetail;
    }
}