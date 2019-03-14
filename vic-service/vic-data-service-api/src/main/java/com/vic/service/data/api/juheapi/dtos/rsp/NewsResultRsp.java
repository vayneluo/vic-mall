package com.vic.service.data.api.juheapi.dtos.rsp;

import com.vic.common.base.result.dtos.rsp.RspData;
import lombok.Data;

import java.util.List;

/**
 * @classname: NewsResultRsp
 * @description: 新闻返回结果
 * @author: Vayne.Luo
 * @date 2019/3/14 10:15
 */
@Data
public class NewsResultRsp extends RspData{

    private static final long serialVersionUID = -1668271527536142222L;

    private String stat;

    private String error_code;

    private List<NewsRsp> data;
}
