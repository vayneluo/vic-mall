package com.vic.common.base.result;

import lombok.Data;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.result
 * @Description: 异常信息
 * @Author: Vayne.Luo
 * @date 2018/12/25
 */
@Data
public class ErrorMessage {

    /** 错误代码 */
    private Integer code;

    /** 错误信息 */
    private String message;

    public ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
