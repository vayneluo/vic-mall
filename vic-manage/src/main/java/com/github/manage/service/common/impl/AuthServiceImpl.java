package com.github.manage.service.common.impl;

import com.github.manage.config.JwtUserDetailService;
import com.github.manage.entity.manage.ManageUser;
import com.github.manage.form.LoginForm;
import com.github.manage.form.RegisterForm;
import com.github.manage.jwt.JwtTokenUtil;
import com.github.manage.service.common.AuthService;
import com.github.manage.service.manage.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.common.impl
 * @Description: 登录相关service
 * @Author: Vayne.Luo
 * @date 2018/12/19
 */
@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUserDetailService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * 用户登录
     * @param loginForm 登录表单
     * @return TOKEN 令牌
     * @throws AuthenticationException
     */
    @Override
    @Transactional
    public String doLogin(LoginForm loginForm) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginForm.getUsername(),loginForm.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        log.info("authentication======" + authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginForm.getUsername());
        return jwtTokenUtil.generateToken(userDetails);
    }
}
