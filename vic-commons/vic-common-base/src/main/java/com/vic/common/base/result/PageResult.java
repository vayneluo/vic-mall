package com.vic.common.base.result;

import com.vic.common.base.result.dtos.rsp.RspPageData;
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
public class PageResult<T> extends GeneralResult{

    private static final long serialVersionUID = 7251515307280186650L;

    private RspPageData<T> rspPageData;

    public PageResult(){}

    public PageResult(RspPageData<T> rspPageData) {
        super();
        this.rspPageData = rspPageData;
    }

    public PageResult(Integer pageSize,Long totalNum,int currentPage,List<T> list) {
        super();
        this.rspPageData = new RspPageData<T>(totalNum,currentPage,pageSize,list);
    }
}
