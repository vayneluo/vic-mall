package com.github.manage.common.util;

import com.github.manage.security.ManageUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.util
 * @Description: security 工具类
 * @Author: Vayne.Luo
 * @date 2018/12/28
 */
public class SecurityUtil {

    /**
     * 获取当前用户
     * @return
     */
    public static Authentication getCurrentUser(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户详情
     * @return 用户信息
     */
    public static ManageUserDetails getCurrentUserDetails(){
        return (ManageUserDetails) getCurrentUser().getPrincipal();
    }
}
