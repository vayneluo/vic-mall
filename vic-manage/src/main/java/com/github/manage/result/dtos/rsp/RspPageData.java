package com.github.manage.result.dtos.rsp;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.result.dtos.rsp
 * @Description: 集合分页返回对象
 * @Author: Vayne.Luo
 * @date 2019/01/24
 */
@Data
public class RspPageData<T> extends RspData {

    private static final long serialVersionUID = -4806921947835937962L;

    /** 总页数 */
    private Integer totalPage = 0;

    /** 总条数 */
    private Long totalNum = 0L;

    /** 每页数据 */
    private int pageSize;

    /** 当前页数 */
    private int currentPage;

    private List<T> list;

    public RspPageData(){}

    public RspPageData(Long totalNum,List<T> list){
        this.totalNum = totalNum;
        this.list = list;
    }

    public RspPageData(Long totalNum,int currentPage,int pageSize,List<T> list){
        if(pageSize != 0){
            totalPage = (int) ((totalNum+pageSize-1)/pageSize);
        }
        this.totalNum = totalNum;
        this.pageSize = pageSize;
        this.list = list;
        this.currentPage = currentPage;
    }

}
