package com.vic.common.base.result.dtos.req.online;

import com.vic.common.base.result.dtos.req.base.ReqObject;

import javax.validation.constraints.NotNull;

/**
 * @classname: RequestEnter
 * @description: 封装请求参数
 * @author: Vayne.Luo
 * @date 2019/3/13 16:28
 */
public class RequestEnter<T extends ReqObject> extends BaseRequestEnter{

    private static final long serialVersionUID = 176730601473442834L;

    @NotNull
    private T reqObject;

    public RequestEnter() {
    }

    public RequestEnter(T reqObject) {
        this.reqObject = reqObject;
    }

    public T getReqObject() {
        return reqObject;
    }

    public void setReqObject(T reqObject) {
        this.reqObject = reqObject;
    }
}
