package com.github.manage.controller;

import com.github.manage.entity.manage.ManageUser;
import com.github.manage.form.LoginForm;
import com.github.manage.form.RegisterForm;
import com.github.manage.result.Result;
import com.github.manage.service.common.AuthService;
import com.github.manage.service.manage.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.controller
 * @Description: 登录控制
 * @Author: Vayne.Luo
 * @date 2018/12/19
 */
@Slf4j
@RestController
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;



    @GetMapping(value = {"/user-info"})
    public Result index(){
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ManageUser manageUser = userService.getUserInfoByName(user.getUsername());
        return Result.success("用户信息",manageUser);
    }

    /**
     * 用户登录
     * @param loginForm 登录表单
     * @return 令牌
     */
    @PostMapping(value = "${jwt.route.login}")
    public Result doLogin(@RequestBody(required = false) LoginForm loginForm){
        log.info("进入登录页面");
        return Result.success("登录成功",authService.doLogin(loginForm));
    }

    @PostMapping(value = "${jwt.route.register}")
    public Result register(@RequestBody RegisterForm registerForm){
        //authService.doRegister(registerForm);
        return Result.success();
    }

}
