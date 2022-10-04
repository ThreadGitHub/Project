package com.coder.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.entity.UserToken;
import com.coder.service.mapper.UserTokenMapper;
import com.coder.service.service.UserTokenService;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

}
