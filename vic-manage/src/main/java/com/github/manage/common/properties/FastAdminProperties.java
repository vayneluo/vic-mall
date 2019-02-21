package com.github.manage.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.properties
 * @Description: FA配置文件
 * @Author: Vayne.Luo
 * @date 2018/12/28
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "fa")
public class FastAdminProperties {

    /** 是否记录操作日志 */
    private boolean openAopLog = true;

    /** 安全相关配置 */
    private SecurityProperties security;
}
