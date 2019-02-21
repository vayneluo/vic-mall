package com.github.manage.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.manage.common.util.CommonConstants;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.jwt
 * @Description: JWT用户实现类
 * @Author: Vayne.Luo
 * @date 2018/12/20
 */
@Data
public class JwtUser extends User{

    private String remoteAddress;

    private String theme;

    private String avatar;

    private Long userId;

    private String email;

    private String mobile;

    private String ssex;

    private String password;

    private String loginTime;

    public JwtUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


}
