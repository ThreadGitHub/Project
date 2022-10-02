package com.coder.service.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtUtils {
    @Value("${jwt.key}")
    private String key;
    @Value("${jwt.timeout}")
    private Integer timeout;

    /**
     * 创建Token
     * @param subject 主体
     * @return
     */
    public String createJWT(String subject) {
        return createJWT(subject, null);
    }

    /**
     * 创建Token
     * @param subject 主体
     * @param ttlMillis 过期时间(单位分钟)
     * @return
     */
    public String createJWT(String subject, Integer ttlMillis) {
        DateTime now = DateTime.now();
        Map<String,Object> params = new HashMap<>();
        //签发时间
        params.put(JWTPayload.ISSUED_AT, now);
        //失效时间
        if (!Objects.isNull(ttlMillis)) {
            params.put(JWTPayload.EXPIRES_AT, now.offsetNew(DateField.MINUTE, ttlMillis));
        } else {
            params.put(JWTPayload.EXPIRES_AT, now.offsetNew(DateField.MINUTE, timeout));
        }
        //生效时间
        params.put(JWTPayload.NOT_BEFORE, now);
        //主体
        params.put(JWTPayload.SUBJECT, subject);
        return JWTUtil.createToken(params, key.getBytes());
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public boolean verify(String token) {
        return JWTUtil.verify(token, key.getBytes());
    }
}
