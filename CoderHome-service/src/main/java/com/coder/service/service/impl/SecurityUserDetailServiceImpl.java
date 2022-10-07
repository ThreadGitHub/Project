package com.coder.service.service.impl;

import com.coder.service.domain.entity.SecurityLoginUser;
import com.coder.service.domain.entity.User;
import com.coder.service.service.UserSerivce;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class SecurityUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserSerivce userSerivce;
    @Resource
    private CacheManager cacheManager;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //校验用户名是否存在
        User user = userSerivce.getUserByName(userName);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        SecurityLoginUser userDetail = new SecurityLoginUser();
        userDetail.setUser(user);
        List<String> authorityList = userSerivce.getAuthorityByUserId(user.getId());
        userDetail.setAuthorites(authorityList);
        //缓存用户
        Cache cache = cacheManager.getCache("loginCache");
        cache.put("login:user:" + userName, userDetail);
        return userDetail;
    }
}