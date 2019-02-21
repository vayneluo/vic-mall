package com.github.manage.result.dtos.rsp;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.result.dtos.rsp
 * @Description: 集合返回对象
 * @Author: Vayne.Luo
 * @date 2019/01/24
 */
@Data
public class RspListData<T> extends RspData {

    private static final long serialVersionUID = -4806921947835937962L;

    private List<T> list;

    public RspListData(){}

    public RspListData(List<T> list){
        this.list = list;
    }

}
