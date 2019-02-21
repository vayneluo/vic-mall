package com.github.manage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.config
 * @Description: spirng mvc 配置
 * @Author: Vayne.Luo
 * @date 2019/01/10
 */
@Slf4j
@Configuration
@AutoConfigureBefore(WebSecurityConfig.class)
public class SpringMvcConfig implements WebMvcConfigurer{

    /**
     * 跨域配置
     */
    public void addCorsMappings(CorsRegistry registry){
        log.info("跨域已设置");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
