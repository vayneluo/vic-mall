package com.vic.common.base.result;

import com.vic.common.base.result.dtos.rsp.RspListData;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.result
 * @Description: 列表返回结果集
 * @Author: Vayne.Luo
 * @date 2019/01/23
 */
@Data
public class ListResult<T> extends GeneralResult{

    private static final long serialVersionUID = -2489478439971890319L;

    private RspListData<T> rspListData;

    public ListResult(){}

    public ListResult(List<T> list) {
        super();
        this.rspListData = new RspListData<>(list);
    }
}
