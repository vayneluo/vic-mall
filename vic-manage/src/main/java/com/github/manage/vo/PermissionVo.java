package com.github.manage.vo;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo
 * @Description: 权限vo
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
@Data
public class PermissionVo extends RspData{

    private static final long serialVersionUID = 8228805004914502309L;

    /**
     * 权限唯一ID
     */
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 权限资源
     */
    private String resources;

    /**
     * 资源名称
     */
    private String title;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 类型，menu或者button
     */
    private Integer permType;

    /**
     * 权限描述
     */
    private String description;

}
