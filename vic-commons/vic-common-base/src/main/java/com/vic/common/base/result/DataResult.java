package com.vic.common.base.result;

import com.vic.common.base.result.dtos.rsp.RspData;
import lombok.Data;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.result
 * @Description: 对象返回类型
 * @Author: Vayne.Luo
 * @date 2019/01/24
 */
@Data
public class DataResult<T extends RspData> extends GeneralResult{

    private static final long serialVersionUID = 6189154545596084237L;

    private T data;

    public DataResult(){}

    public DataResult(T data){
        super();
        this.data = data;
    }
}
