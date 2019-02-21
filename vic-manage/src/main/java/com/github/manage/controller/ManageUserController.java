package com.github.manage.controller;

import com.github.manage.form.RegisterForm;
import com.github.manage.form.common.IdForm;
import com.github.manage.form.user.UserListSearchForm;
import com.github.manage.result.GeneralResult;
import com.github.manage.service.manage.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.controller
 * @Description: 后台用户Controller
 * @Author: Vayne.Luo
 * @date 2018/12/19
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class ManageUserController {

    @Autowired
    UserService userService;

    /**
     * 添加后台用户
     * @param registerForm 用户表单
     */
    @PostMapping("/add")
    public GeneralResult register(@RequestBody RegisterForm registerForm){
        return userService.addUser(registerForm);
    }

    /**
     * 获取所有后台用户
     */
    @PostMapping(value = "/list")
    public GeneralResult queryManageUserList(@RequestBody UserListSearchForm searchForm){
        return userService.queryManageUserList(searchForm);
    }

    /**
     * 获取用户信息（基础信息+权限）
     */
    @GetMapping("/info")
    public GeneralResult getUserInfo(){
        return userService.getUserInfo();
    }

    /**
     * 根据用户ID查询用户信息
     */
    @PostMapping("/detail")
    public GeneralResult queryUserDetailById(@RequestBody IdForm idForm){
        return userService.queryUserDetailById(idForm);
    }

    /**
     * 更新用户信息（角色）
     */
    public GeneralResult updateUserInfo(){
        return null;
    }
}
