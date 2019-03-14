package com.vic.service.data.controller;

import com.vic.common.base.result.DataResult;
import com.vic.common.base.result.ListResult;
import com.vic.common.base.result.dtos.req.online.RequestEnter;
import com.vic.service.data.api.juheapi.INewsWebService;
import com.vic.service.data.api.juheapi.dtos.req.JuheApiReq;
import com.vic.service.data.api.juheapi.dtos.rsp.NewsRsp;
import com.vic.service.data.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @classname: NewsController
 * @description: 聚合数据新闻API
 * @author: Vayne.Luo
 * @date 2019/3/13 16:13
 */
@RestController
@RequestMapping(value = "/vic/news")
public class NewsController implements INewsWebService{

    @Autowired
    NewsService newsService;

    /**
     * @description: 查询最新头条新闻数据
     * @author Vayne.luo
     * @date 2019/3/13 16:36　 
     */
    @Override
    @PostMapping(value = "/latest")
    public ListResult<NewsRsp> queryLatestNewsList(@RequestBody RequestEnter<JuheApiReq> requestEnter) {
        return newsService.queryLatestNewsList(requestEnter);
    }
}
