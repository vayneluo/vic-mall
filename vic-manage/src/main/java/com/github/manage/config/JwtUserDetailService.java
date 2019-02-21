package com.github.manage.config;

import com.github.manage.entity.manage.ManageUser;
import com.github.manage.service.manage.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service
 * @Description: 自定义登录验证
 * @Author: Vayne.Luo
 * @date 2018/12/18
 */
@Service
public class JwtUserDetailService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ManageUser manageUser = userService.getUserInfoByName(username);
        if(null == manageUser){
            throw new UsernameNotFoundException("用户不存在！");
        }
        return new User(manageUser.getUsername(),manageUser.getPassword(),AuthorityUtils.NO_AUTHORITIES);
        //return new JwtUser(manageUser.getUsername(),manageUser.getPassword(),manageUser.getIsDel(),AuthorityUtils.NO_AUTHORITIES);
        /*return new User(username,passwordEncoder.encode("123456"),
                true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
   */ }
}
