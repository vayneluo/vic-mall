package com.github.manage.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.security
 * @Description: Security自定义用户
 * @Author: Vayne.Luo
 * @date 2018/12/26
 */
@Data
public class ManageUserDetails extends User{

    private String remoteAddress;

    private String theme;

    private String avatar;

    private Long userId;

    private String email;

    private String mobile;

    private String ssex;

    private String password;

    private String loginTime;

    public ManageUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
