package com.github.manage.common.properties;

import lombok.Data;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.properties
 * @Description: 认证相关属性
 * @Author: Vayne.Luo
 * @date 2018/12/29
 */
@Data
public class SecurityProperties {

    /** 登录页URL */
    private String loginUrl;

    /** 登出URL */
    private String logoutUrl;

    /** 首页URL */
    private String indexUrl;

    /** 免认证路径 */
    private String anonUrls;

    /** 登录认证路径 */
    private String loginProcessingUrl;

}
