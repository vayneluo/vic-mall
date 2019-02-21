package com.github.manage.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.form
 * @Description: 登录表单
 * @Author: Vayne.Luo
 * @date 2018/12/20
 */
@Data
public class LoginForm implements Serializable{

    private String username;

    private String password;
}
