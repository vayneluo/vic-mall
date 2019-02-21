package com.github.manage.repository.manage;

import com.github.manage.common.mapper.MyMapper;
import com.github.manage.entity.manage.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单mapper
 */
@Mapper
public interface MenuMapper extends MyMapper<Menu> {

    /**
     * 根据用户名获取权限集合
     * @param userName 用户名
     * @return 权限列表
     */
    List<Menu> findUserPermissions(String userName);
}