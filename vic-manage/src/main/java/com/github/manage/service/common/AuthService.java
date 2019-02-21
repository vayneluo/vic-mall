package com.github.manage.service.common;

import com.github.manage.form.LoginForm;
import com.github.manage.form.RegisterForm;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.common
 * @Description: 登录
 * @Author: Vayne.Luo
 * @date 2018/12/19
 */
public interface AuthService {

    /**
     * 用户登录
     */
    String doLogin(LoginForm loginForm) throws AuthenticationException;
}
