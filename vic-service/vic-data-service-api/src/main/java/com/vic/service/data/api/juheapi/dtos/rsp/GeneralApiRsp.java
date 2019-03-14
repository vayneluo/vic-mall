package com.vic.service.data.api.juheapi.dtos.rsp;

import com.vic.common.base.result.dtos.rsp.RspData;
import lombok.Data;

/**
 * @classname: GeneralApiRsp
 * @description: API通用返回对象
 * @author: Vayne.Luo
 * @date 2019/3/14 10:18
 */
@Data
public class GeneralApiRsp extends RspData{

    private static final long serialVersionUID = -4561558197113559632L;

    private String reason;

    private NewsResultRsp result;

}
