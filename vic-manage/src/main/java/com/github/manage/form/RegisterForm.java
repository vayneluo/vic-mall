package com.github.manage.form;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.form
 * @Description: 注册表单
 * @Author: Vayne.Luo
 * @date 2018/12/19
 */
@Data
public class RegisterForm {

    /** 用户名 */
    @NotNull
    private String username;

    /** 昵称 */
    private String nickname;

    /** 密码 */
    @NotNull
    private String password;

    /** 电子邮件 */
    @NotNull
    @Email
    private String mail;

    /** 电话 */
    private String phone;

    /** 状态 */
    private Integer state;
}
