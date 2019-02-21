package com.github.manage.vo;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo
 * @Description: 系统用户vo
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
@Data
public class SysUserVo extends RspData{

    private static final long serialVersionUID = -1477820755941212363L;

    /** 用户ID */
    private Long id;

    /** 用户名称 */
    private String username;

    /** 手机号 */
    private String phone;

    /** 头像 */
    private String avatar;

    /** 用户角色列表 */
    private List<RoleVo> roles;

    /** 用户菜单列表 */
    private List<MenuVo> menus;

    /** 用户按钮列表 */
    private List<ButtonVo> buttons;
}
