package com.vic.common.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.annotation
 * @Description: 操作日志
 * @Author: Vayne.Luo
 * @date 2018/12/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
