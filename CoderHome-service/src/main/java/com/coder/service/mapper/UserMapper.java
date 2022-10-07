package com.coder.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coder.service.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户id查询所有的权限key
     * @param userId
     * @return
     */
    List<String> getAuthorityByUserId(Long userId);
}
