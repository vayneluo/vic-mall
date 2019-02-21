package com.github.manage.service.manage.impl;

import com.github.manage.common.util.CommonConstants;
import com.github.manage.entity.manage.*;
import com.github.manage.service.manage.SysRoleService;
import com.github.manage.vo.PermissionVo;
import com.github.manage.vo.RoleVo;
import com.github.manage.vo.user.RoleDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage.impl
 * @Description: 角色服务实现类
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
@Service
public class SysRoleServiceImpl extends UserBaseServiceImpl implements SysRoleService{


    /**
     * 根据用户ID查询用户角色信息
     * @param id 用户ID
     * @return 角色信息
     */
    @Override
    @Transactional
    public List<RoleVo> getRoleSetByUser(Long id) {
        return queryRoleVoList(id);
    }

    /**
     * 根据用户id查询角色vo
     * @param id 用户id
     * @return 角色vo列表
     */
    private List<RoleVo> queryRoleVoList(Long id) {
        List<RoleVo> roleVoList = new ArrayList<>();
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<SysUserRole> userRoleList = userRoleMapper.selectByExample(example);
        //用户无角色
        if(null == userRoleList || userRoleList.size() <= 0){
            return roleVoList;
        }
        //取出用户角色ID集合
        List<Long> roleIds = userRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andIdIn(roleIds);
        List<SysRole> sysRoleList = roleMapper.selectByExample(roleExample);
        sysRoleList.forEach(sysUserRole -> {
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(sysUserRole,roleVo);
            roleVoList.add(roleVo);
        });

        //处理角色权限问题
        Map<Long,List<PermissionVo>> permissionMap = queryPermissionMap(roleIds);
        dealUserRolePermission(roleVoList,permissionMap);

        return roleVoList;
    }

    /**
     * 组装角色下权限数据
     * @param roleVoList 角色vo列表
     * @param permissionMap  权限vo列表
     */
    private void dealUserRolePermission(List<RoleVo> roleVoList, Map<Long,List<PermissionVo>> permissionMap) {
        if(null == permissionMap || permissionMap.size() <= 0){
            return;
        }
        roleVoList.forEach(roleVo -> {
            if(permissionMap.containsKey(roleVo.getId())){
                roleVo.setPermissions(permissionMap.get(roleVo.getId()));
            }
        });
    }

    /**
     * 查询一批权限集合
     * @param roleIds 角色IDS
     * @return 权限集合
     */
    private Map<Long,List<PermissionVo>> queryPermissionMap(List<Long> roleIds) {
        Map<Long,List<PermissionVo>> permissionMap = new HashMap<>();

        SysRolePermissionExample permissionExample = new SysRolePermissionExample();
        permissionExample.createCriteria().andRoleIdIn(roleIds);
        List<SysRolePermission> rolePermissions = rolePermissionMapper.selectByExample(permissionExample);
        //获取权限列表
        List<Long> permissionIds = rolePermissions.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());

        SysPermissionExample example = new SysPermissionExample();
        example.createCriteria().andIdIn(permissionIds);
        List<SysPermission> permissions = permissionMapper.selectByExample(example);
        if(null == permissions || permissions.size() <= 0){
            return permissionMap;
        }

        //角色分组
        Map<Long,List<SysRolePermission>> roleMap = rolePermissions.stream().collect(Collectors.groupingBy(SysRolePermission::getRoleId));

        roleMap.forEach((k,v) -> {
            List<PermissionVo> permissionVos = new ArrayList<>();
            v.forEach(sysRolePermission -> {
                permissions.forEach(sysPermission -> {
                    if(sysRolePermission.getPermissionId().equals(sysPermission.getId())){
                        PermissionVo permissionVo = new PermissionVo();
                        BeanUtils.copyProperties(sysPermission,permissionVo);
                        permissionVos.add(permissionVo);
                    }
                });
            });
            permissionMap.put(k,permissionVos);
        });
        return permissionMap;
    }

    /**
     * 根据用户ID查询角色信息
     */
    @Override
    @Transactional
    public List<RoleDetailVo> getRoleDetailById(Long id) {
        List<RoleDetailVo> roleDetailVoList = new ArrayList<>();
        // 获取所有角色信息
        List<SysRole> sysRoleList = queryAllRoles();
        if(sysRoleList.size() <= 0){
            return roleDetailVoList;

        }
        // 获取用户下角色信息
        List<SysRole> userRoleList = queryUserRolesList(id);
        sysRoleList.forEach(sysRole -> {
            RoleDetailVo roleDetailVo = new RoleDetailVo();
            BeanUtils.copyProperties(sysRole,roleDetailVo);
            if(null != userRoleList && userRoleList.size() > 0){
                userRoleList.forEach(userRole ->{
                    if(sysRole.getId().equals(userRole.getId())){
                        roleDetailVo.setSelected(true);
                    }
                });
            }
            roleDetailVoList.add(roleDetailVo);
        });
        return roleDetailVoList;
    }

    /**
     * 查询用户下角色
     */
    private List<SysRole> queryUserRolesList(Long id) {
        List<SysRole> roleList = new ArrayList<>();
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<SysUserRole> userRoleList = userRoleMapper.selectByExample(example);
        //用户无角色
        if(null == userRoleList || userRoleList.size() <= 0){
            return roleList;
        }
        //取出用户角色ID集合
        List<Long> roleIds = userRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andIdIn(roleIds);
        roleList = roleMapper.selectByExample(roleExample);
        return roleList;
    }

    private List<SysRole> queryAllRoles() {
        SysRoleExample roleExample = new SysRoleExample();
        roleExample.createCriteria().andStateEqualTo(CommonConstants.STATUS_VALID);
        roleExample.setOrderByClause("create_time desc");
        List<SysRole> sysRoleList = roleMapper.selectByExample(roleExample);
        if(null == sysRoleList || sysRoleList.size() <= 0){
            return new ArrayList<>();
        }
        return sysRoleList;
    }
}
