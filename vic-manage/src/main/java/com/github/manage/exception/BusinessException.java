package com.github.manage.exception;

import com.github.manage.common.enums.result.BizResultEnumBase;
import lombok.Data;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.exception
 * @Description: 自定义业务异常
 * @Author: Vayne.Luo
 * @date 2018/12/25
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -2559485084282541929L;

    /** 错误代码 */
    private Integer code;

    /** 错误信息 */
    private String message;

    public BusinessException() {
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(BizResultEnumBase bizResultEnumBase){
        super(bizResultEnumBase.getBizResultEnumObject().getMessage());
        this.code = bizResultEnumBase.getBizResultEnumObject().getBizCode();
        this.message = bizResultEnumBase.getBizResultEnumObject().getMessage();
    }
}
