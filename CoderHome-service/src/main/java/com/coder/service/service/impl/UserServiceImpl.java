package com.coder.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.dto.UserDTO;
import com.coder.service.domain.entity.User;
import com.coder.service.mapper.UserMapper;
import com.coder.service.service.UserSerivce;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {
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
}
