package com.vic.mini.service;

import com.vic.common.base.result.DataResult;
import com.vic.common.base.result.GeneralResult;
import com.vic.common.base.result.dtos.req.online.RequestEnter;
import com.vic.mini.common.form.JuheApiForm;
import com.vic.mini.common.vo.news.NewsVo;
import com.vic.service.data.api.juheapi.INewsWebService;
import com.vic.service.data.api.juheapi.dtos.req.JuheApiReq;
import com.vic.service.data.api.juheapi.dtos.rsp.NewsRsp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @classname: NewsService
 * @description: 新闻头条服务类
 * @author: Vayne.Luo
 * @date 2019/3/13 15:08
 */
@Service
public class NewsService {

    @Autowired
    INewsWebService newsWebService;
    
    /**
     * @description: 查询最新新闻列表
     * @author Vayne.luo
     * @date 2019/3/13 15:53　
     */
    public DataResult<NewsVo> queryLatestNewsList(JuheApiForm apiForm) {
        JuheApiReq req = new JuheApiReq();
        BeanUtils.copyProperties(apiForm,req);
        RequestEnter<JuheApiReq> enter = new RequestEnter<>(req);
        DataResult<NewsRsp> dataResult = newsWebService.queryLatestNewsList(enter);
        NewsRsp rsp = dataResult.getData();
        NewsVo newsVo = new NewsVo();
        BeanUtils.copyProperties(rsp,newsVo);
        return new DataResult<>(newsVo);
    }
}
