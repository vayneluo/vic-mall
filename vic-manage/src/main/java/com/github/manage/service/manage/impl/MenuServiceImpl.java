package com.github.manage.service.manage.impl;

import com.github.manage.entity.manage.Menu;
import com.github.manage.repository.manage.MenuMapper;
import com.github.manage.service.manage.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage
 * @Description: 菜单服务实现类
 * @Author: Vayne.Luo
 * @date 2018/12/26
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    /**
     * 根据用户名获取权限集合
     * @param username 用户名
     * @return 权限列表
     */
    @Override
    public String findUserPermissionsByName(String username) {
        //List<Menu> menus = menuMapper.findUserPermissions(username);
        //return menus.stream().map(Menu::getPerms).collect(Collectors.joining(","));
        return null;
    }
}
