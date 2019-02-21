package com.github.manage.config;

import com.github.manage.exception.BusinessException;
import com.github.manage.result.GeneralResult;
import com.github.manage.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.config
 * @Description: 全局异常捕捉
 * @Author: Vayne.Luo
 * @date 2018/12/25
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕捉自定义异常
     * @param request request
     * @param e 异常
     * @param response response
     * @return 响应结果
     */
    @ExceptionHandler(value = BusinessException.class)
    public GeneralResult businessExceptionHandle(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
        BusinessException businessException = (BusinessException) e;
        return GeneralResult.error(businessException);
    }

    /**
     * 捕捉运行时异常
     * @param request request
     * @param e 异常
     * @param response response
     * @return 响应结果
     */
    /*@ExceptionHandler(value = RuntimeException.class)
    public Result runtimeExceptionHandle(HttpServletRequest request, final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException businessException = (RuntimeException) e;
        return Result.error(400,businessException.getMessage(),null);
    }*/
}
