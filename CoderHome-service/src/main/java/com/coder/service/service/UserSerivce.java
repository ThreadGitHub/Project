package com.coder.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coder.service.domain.dto.UserDTO;
import com.coder.service.domain.entity.User;
import com.coder.service.utils.ResponseUtils;

import java.util.List;

public interface UserSerivce extends IService<User> {
    /**
     * 根据用户id获取用户权限key
     */
    List<String> getAuthorityByUserId(Long userId);

    /**
     * 查询用户是否存在
     * @param userName 用户名
     * @return
     */
    boolean hasUserExsit(String userName);

    /**
     * 根据用户名查询用户
     * @return
     */
    User getUserByName(String userName);

    /**
     * 登录
     * @param user
     */
    ResponseUtils login(UserDTO user);

    /**
     * 注册
     * @param user
     * @return
     */
    ResponseUtils register(UserDTO user);
}
