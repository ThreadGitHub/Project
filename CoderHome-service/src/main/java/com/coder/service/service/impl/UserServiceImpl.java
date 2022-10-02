package com.coder.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.entity.User;
import com.coder.service.mapper.UserMapper;
import com.coder.service.service.UserSerivce;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserSerivce {

}
