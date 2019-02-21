package com.vic.common.base.enums;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.enums
 * @Description: 日志类型枚举
 * @Author: Vayne.Luo
 * @date 2018/12/27
 */
public enum LogTypeEnum {
    /** 登录日志 */
    LOGIN_LOG(10),

    /** 操作日志 */
    METHOD_LOG(20);

    LogTypeEnum(Integer type) {
        this.type = type;
    }

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
