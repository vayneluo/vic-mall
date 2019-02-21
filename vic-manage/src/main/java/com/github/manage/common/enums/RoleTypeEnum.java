package com.github.manage.common.enums;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.enums
 * @Description: 角色类型枚举[菜单，按钮]
 * @Author: Vayne.Luo
 * @date 2019/01/19
 */
public enum  RoleTypeEnum {

    /** 菜单 */
    MENU(10),

    /** 操作日志 */
    BUTTON(20);

    private Integer type;

    RoleTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
