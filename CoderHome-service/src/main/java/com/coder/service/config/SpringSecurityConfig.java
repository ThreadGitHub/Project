package com.coder.service.config;

import com.coder.service.filter.AuthenicationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private AuthenicationTokenFilter filter;

    /**
     * 配置加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭 csrf
        http.csrf().disable();
        //关闭从session中获取
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //授权
        http.authorizeRequests()
                //放行 Kenife4j文档不用授权登录访问
                .antMatchers("/doc.html","/webjars/**","/img.icons/**", "/swagger-resources/**", "/v2/api-docs").permitAll()
                //放行登录请求
                .antMatchers("/login", "/register").permitAll()
                //其他请求需要认证通过才能访问
                .anyRequest().authenticated();
        //增加自定义获取token信息的过滤器到 security 过滤器之前
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
