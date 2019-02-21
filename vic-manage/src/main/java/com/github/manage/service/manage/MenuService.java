package com.github.manage.service.manage;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage
 * @Description: 菜单服务类
 * @Author: Vayne.Luo
 * @date 2018/12/26
 */
public interface MenuService {

    /**
     * 根据用户名获取权限集合
     * @param username 用户名
     * @return 权限集合
     */
    String findUserPermissionsByName(String username);
}
