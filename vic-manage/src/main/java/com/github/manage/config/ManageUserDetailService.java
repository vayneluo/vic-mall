package com.github.manage.config;

import com.github.manage.entity.manage.ManageUser;
import com.github.manage.exception.BusinessException;
import com.github.manage.security.ManageUserDetails;
import com.github.manage.service.manage.MenuService;
import com.github.manage.service.manage.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.config
 * @Description: Security自定义用户验证
 * @Author: Vayne.Luo
 * @date 2018/12/26
 */
@Service
public class ManageUserDetailService implements UserDetailsService{

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ManageUser manageUser = userService.getUserInfoByName(username);
        if(null == manageUser){
            throw new UsernameNotFoundException("用户不存在！");
        }
        //根据用户名获取权限集合
        String permissions = this.menuService.findUserPermissionsByName(username);
        ManageUserDetails userDetails = new ManageUserDetails(manageUser.getUsername(),manageUser.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
        BeanUtils.copyProperties(manageUser,userDetails);
        return userDetails;
    }
}
