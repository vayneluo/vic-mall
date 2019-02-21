package com.github.manage.service.manage.impl;

import com.github.manage.repository.manage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage.impl
 * @Description: 用户基础服务
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
public class UserBaseServiceImpl {

    @Autowired
    SysRoleMapper roleMapper;

    @Autowired
    SysUserRoleMapper userRoleMapper;

    @Autowired
    ManageUserMapper manageUserMapper;

    @Autowired
    SysPermissionMapper permissionMapper;

    @Autowired
    SysRolePermissionMapper rolePermissionMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

}
