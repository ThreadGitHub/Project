package com.coder.service.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.coder.service.domain.entity.SecurityLoginUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 单次过滤器
 */
@Component
public class AuthenicationTokenFilter extends OncePerRequestFilter {
    @Resource
    private CacheManager cacheManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        //如果没有token就直接放行，留给security鉴权自然就 403无权
        if (StringUtils.isBlank(token)) {
            filterChain.doFilter(request, response);
        } else {
            try {
                //去掉前置头
                if (token.startsWith("Bearer")) {
                    token = token.replace("Bearer", "");
                }
                JWT jwt = JWTUtil.parseToken(token);
                JSONObject payloads = jwt.getPayloads();
                String userName = payloads.getStr(JWTPayload.SUBJECT);
                Cache.ValueWrapper loginCache = cacheManager.getCache("loginCache").get("login:user:" + userName);
                if (!Objects.isNull(loginCache)) {
                    SecurityLoginUser userDetail = (SecurityLoginUser) loginCache.get();
                    UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetail.getUsername(), userDetail.getPassword(), userDetail.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(userToken);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                filterChain.doFilter(request, response);
            }
        }
    }
}
