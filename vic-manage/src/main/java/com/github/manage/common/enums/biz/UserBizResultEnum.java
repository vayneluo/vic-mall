package com.github.manage.common.enums.biz;

import com.github.manage.common.enums.result.BizResultEnumBase;
import com.github.manage.common.enums.result.BizResultEnumObject;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.enums.biz
 * @Description: 用户相关提示信息
 * @Author: Vayne.Luo
 * @date 2018/12/29
 */
public enum UserBizResultEnum implements BizResultEnumBase{

    USER_EXIST(1000,"当前用户已存在！") ,

    USER_NOT_EXIST(1001,"当前用户不存在！") ,

    ;

    private Integer code;

    private String message;

    /** 枚举值对象 */
    private BizResultEnumObject bizResultEnumObject;

    UserBizResultEnum(Integer code, String message) {
        bizResultEnumObject = new BizResultEnumObject(code,message);
    }

    UserBizResultEnum(Integer code, String message,String viewName) {
        bizResultEnumObject = new BizResultEnumObject(code,message,viewName);
    }


    @Override
    public BizResultEnumObject getBizResultEnumObject() {
        return bizResultEnumObject;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
