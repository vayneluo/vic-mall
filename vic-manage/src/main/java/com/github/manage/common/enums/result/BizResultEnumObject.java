package com.github.manage.common.enums.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.enums.result
 * @Description: 业务异常对象
 * @Author: Vayne.Luo
 * @date 2018/12/29
 */
@Data
public class BizResultEnumObject implements Serializable{

    private static final long serialVersionUID = -7847691408539144973L;

    private int bizCode;

    private String message;

    private String viewName;

    public BizResultEnumObject(int bizCode, String message, String viewName) {
        this.bizCode = bizCode;
        this.message = message;
        this.viewName = viewName;
    }

    public BizResultEnumObject(int bizCode, String message) {
        this.bizCode = bizCode;
        this.message = message;
    }
}
