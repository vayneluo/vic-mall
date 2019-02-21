package com.github.manage.vo;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;
import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo
 * @Description: 菜单vo
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
@Data
public class MenuVo extends RspData{

    private static final long serialVersionUID = -7858352007840395453L;

    /** 菜单ID */
    private Long id;

    /** 父菜单ID */
    private Long parentId;

    /** 图标 */
    private String icon;

    /** 资源 */
    private String resources;

    /** 菜单名称 */
    private String title;

    /** 子菜单 */
    private List<MenuVo> children;
}
