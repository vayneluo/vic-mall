package com.github.manage.service.manage.impl;

import com.github.manage.common.enums.RoleTypeEnum;
import com.github.manage.common.enums.biz.UserBizResultEnum;
import com.github.manage.common.util.CommonConstants;
import com.github.manage.common.util.TreeBuilder;
import com.github.manage.entity.manage.ManageUser;
import com.github.manage.entity.manage.ManageUserExample;
import com.github.manage.exception.BusinessException;
import com.github.manage.form.RegisterForm;
import com.github.manage.form.common.IdForm;
import com.github.manage.form.user.UserListSearchForm;
import com.github.manage.result.DataResult;
import com.github.manage.result.GeneralResult;
import com.github.manage.result.PageResult;
import com.github.manage.result.dtos.rsp.RspPageData;
import com.github.manage.service.manage.UserService;
import com.github.manage.vo.MenuVo;
import com.github.manage.vo.RoleVo;
import com.github.manage.vo.SysUserVo;
import com.github.manage.vo.user.ManageUserDefaultVo;
import com.github.manage.vo.user.ManageUserListVo;
import com.github.manage.vo.user.RoleDetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage.user.impl
 * @Description: 用户服务实现类
 * @Author: Vayne.Luo
 * @date 2018/12/18
 */
@Service
public class UserServiceImpl extends UserBaseServiceImpl implements UserService{

    @Autowired
    SysRoleServiceImpl sysRoleService;

    /**
     * 添加用户
     * @param registerForm 用户表单
     * @return 添加成功
     */
    @Override
    @Transactional
    public GeneralResult addUser(RegisterForm registerForm) {
        //校验用户是否存在
        if(checkUserExistByName(registerForm.getUsername())){
            throw new BusinessException(UserBizResultEnum.USER_EXIST);
        }
        ManageUser manageUser = new ManageUser();
        BeanUtils.copyProperties(registerForm,manageUser);
        manageUser.setPassword(this.passwordEncoder.encode(manageUser.getPassword()));
        this.manageUserMapper.insertSelective(manageUser);
        return new GeneralResult();
    }

    /**
     * 校验用户是否存在
     * @param username 用户名
     */
    private boolean checkUserExistByName(String username) {
        boolean flag = true;
        ManageUserExample example = new ManageUserExample();
        example.createCriteria().andUsernameEqualTo(username).andStateEqualTo(CommonConstants.STATUS_VALID);
        List<ManageUser> userList = this.manageUserMapper.selectByExample(example);
        if(null == userList || userList.size() <= 0){
            flag = false;
        }
        return flag;
    }

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    @Override
    public ManageUser getUserInfoByName(String username) {
        ManageUser manageUser = new ManageUser();
        manageUser.setUsername(username);
        return manageUserMapper.selectOne(manageUser);
    }

    /**
     * 根据用户名编号查询用户信息
     * @param id 用户名编号
     */
    public ManageUser getUserInfoById(Long id) {
        ManageUser manageUser = manageUserMapper.selectByPrimaryKey(id);
        if(null == manageUser){
            throw new BusinessException(UserBizResultEnum.USER_NOT_EXIST);
        }
        return manageUser;
    }

    /**
     * 获取用户信息（基础信息+权限）
     */
    @Override
    @Transactional(readOnly = true)
    public DataResult<SysUserVo> getUserInfo() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ManageUser manageUser = getUserInfoByName(user.getUsername());
        SysUserVo sysUserVo = new SysUserVo();
        BeanUtils.copyProperties(manageUser,sysUserVo);

        //查询角色信息
        List<RoleVo> roleVoList = sysRoleService.getRoleSetByUser(sysUserVo.getId());
        sysUserVo.setRoles(roleVoList);

        //组装动态权限菜单
        List<MenuVo> menus = dealUserRoleMenus(roleVoList);
        sysUserVo.setMenus(TreeBuilder.findRoots(menus));
        return new DataResult<>(sysUserVo);
    }

    /**
     * 处理菜单数据
     * @param roleVoList 角色列表
     * @return 菜单信息
     */
    private List<MenuVo> dealUserRoleMenus(List<RoleVo> roleVoList) {
        List<MenuVo> menus = new ArrayList<>();
        if(null == roleVoList || roleVoList.size() <= 0){
            return menus;
        }
        roleVoList.forEach(roleVo -> {
            if(null != roleVo.getPermissions()){
                roleVo.getPermissions().forEach(permissionVo -> {
                    if(permissionVo.getPermType().equals(RoleTypeEnum.MENU.getType())){
                        MenuVo menuVo = new MenuVo();
                        BeanUtils.copyProperties(permissionVo,menuVo);
                        menus.add(menuVo);
                    }
                });
            }
        });
        return menus;
    }

    /**
     * 查询所有用户列表
     * @param searchForm
     */
    @Override
    @Transactional(readOnly = true)
    public PageResult<ManageUserListVo> queryManageUserList(UserListSearchForm searchForm) {
        PageHelper.startPage(searchForm.getCurrentPage(),searchForm.getPageSize());
        List<ManageUserListVo> userListVoList = new ArrayList<>();
        ManageUserExample example = new ManageUserExample();
        example.createCriteria();
        example.setOrderByClause("create_time desc");
        List<ManageUser> manageUserList = manageUserMapper.selectByExample(example);
        RspPageData<ManageUserListVo> rspPageData = new RspPageData<>(0L,new ArrayList<>());
        if(null == manageUserList || manageUserList.size() <= 0){
            return new PageResult<>(rspPageData);
        }
        //按创建实际排序
        manageUserList.sort((u1,u2) -> u2.getCreateTime().compareTo(u1.getCreateTime()));
        manageUserList.forEach(manageUser -> {
            ManageUserListVo listVo = new ManageUserListVo();
            BeanUtils.copyProperties(manageUser,listVo);
            userListVoList.add(listVo);
        });
        PageInfo pageInfo = new PageInfo(manageUserList);
        rspPageData = new RspPageData<>(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),userListVoList);
        //返回分页对象
        return new PageResult<>(rspPageData);
    }

    /**
     * 查询指定用户信息
     * @param idForm id
     */
    @Override
    public DataResult<ManageUserDefaultVo> queryUserDetailById(IdForm idForm) {
        // 查询用户基本信息
        ManageUser manageUser = getUserInfoById(idForm.getId());
        ManageUserDefaultVo manageUserDefaultVo = new ManageUserDefaultVo();
        BeanUtils.copyProperties(manageUser,manageUserDefaultVo);

        //查询角色信息
        List<RoleDetailVo> roleVoList = sysRoleService.getRoleDetailById(idForm.getId());
        manageUserDefaultVo.setRoleVoList(roleVoList);
        return new DataResult<>(manageUserDefaultVo);
    }
}
