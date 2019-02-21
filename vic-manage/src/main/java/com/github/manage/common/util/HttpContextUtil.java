package com.github.manage.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.util
 * @Description: HttpContextUtil
 * @Author: Vayne.Luo
 * @date 2018/12/27
 */
public class HttpContextUtil {

    private HttpContextUtil(){

    }

    public static HttpServletRequest getServletRequest(){
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
