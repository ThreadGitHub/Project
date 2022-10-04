package com.coder.service.filter;

import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.coder.service.domain.entity.UserToken;
import com.coder.service.service.UserSerivce;
import com.coder.service.service.UserTokenService;
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
    private UserTokenService userTokenService;
    @Resource
    private UserSerivce userSerivce;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        //如果没有token就直接放行，留给security鉴权自然就 403无权
        if (Objects.isNull(token)) {
            filterChain.doFilter(request, response);
        } else {
            try {
                JWT jwt = JWTUtil.parseToken(token);
                JSONObject payloads = jwt.getPayloads();
                String userName = payloads.getStr(JWTPayload.SUBJECT);
                LambdaQueryWrapper<UserToken> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(UserToken::getUserName, userName);
                UserToken userToken = userTokenService.getOne(queryWrapper);
                if (!Objects.isNull(userToken)) {
                    if (userToken.getToken().equals(token)) {
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userName, null, null);
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
            } catch (Exception e) {
            } finally {
                filterChain.doFilter(request, response);
            }
        }
    }
}
