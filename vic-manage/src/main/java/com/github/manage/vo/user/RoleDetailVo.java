package com.github.manage.vo.user;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo.user
 * @Description: 角色详情
 * @Author: Vayne.Luo
 * @date 2019/01/30
 */
@Data
public class RoleDetailVo extends RspData{

    private static final long serialVersionUID = -8531024399338025343L;

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

    /** 角色是否选中 */
    private boolean isSelected = false;

}
