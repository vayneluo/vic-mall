package com.github.manage.service.manage;

import com.github.manage.entity.manage.ManageUser;
import com.github.manage.form.RegisterForm;
import com.github.manage.form.common.IdForm;
import com.github.manage.form.user.UserListSearchForm;
import com.github.manage.result.GeneralResult;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage.user
 * @Description: 用户服务接口
 * @Author: Vayne.Luo
 * @date 2018/12/18
 */
public interface UserService {

    /**
     * 保存用户
     * @param registerForm 用户表单
     * @return
     */
    GeneralResult addUser(RegisterForm registerForm);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    ManageUser getUserInfoByName(String username);

    /**
     * 获取用户信息（基础信息+权限）
     */
    GeneralResult getUserInfo();

    /**
     * 查询后台所有用户列表
     * @param searchForm
     */
    GeneralResult queryManageUserList(UserListSearchForm searchForm);


    /**
     * 用户信息
     * @param idForm id
     */
    GeneralResult queryUserDetailById(IdForm idForm);
}
