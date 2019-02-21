package com.github.manage.vo;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo
 * @Description: 角色VO
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
@Data
public class RoleVo extends RspData{

    private static final long serialVersionUID = 1654528546674247402L;

    /** 角色ID */
    private Long id;

    /**
     * 系统角色描述
     */
    private String description;

    /**
     * 系统角色名称
     */
    private String name;

    /** 权限列表 */
    private List<PermissionVo> permissions;
}
