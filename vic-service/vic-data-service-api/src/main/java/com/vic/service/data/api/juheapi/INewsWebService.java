package com.vic.service.data.api.juheapi;

import com.vic.common.base.result.DataResult;
import com.vic.common.base.result.ListResult;
import com.vic.common.base.result.dtos.req.online.RequestEnter;
import com.vic.service.data.api.juheapi.dtos.req.JuheApiReq;
import com.vic.service.data.api.juheapi.dtos.rsp.NewsRsp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @classname: INewsWebService
 * @description: 聚合api webservice
 * @author: Vayne.Luo
 * @date 2019/3/13 16:11
 */
@FeignClient(name = "vic-data-service")
public interface INewsWebService {

    @PostMapping(value = "/vic/news/latest")
    ListResult<NewsRsp> queryLatestNewsList(RequestEnter<JuheApiReq> requestEnter);
}
