package com.vic.service.data.service;

import com.vic.common.base.result.DataResult;
import com.vic.common.base.result.dtos.req.online.RequestEnter;
import com.vic.service.data.api.juheapi.dtos.req.JuheApiReq;
import com.vic.service.data.api.juheapi.dtos.rsp.NewsRsp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @classname: NewsService
 * @description: 调用聚合API新闻接口
 * @author: Vayne.Luo
 * @date 2019/3/13 16:54
 */
@Slf4j
@Service
public class NewsService {

    @Autowired
    private RestTemplate restTemplate;

    // 聚合API appKey
    public static final String APP_KEY = "523f240ba281b6bbb2c95e788217c54f";

    @Value(value = "${juhe.api.news.url}")
    private String apiUrl;

    public DataResult<NewsRsp> queryLatestNewsList(RequestEnter<JuheApiReq> requestEnter) {
        JuheApiReq req = requestEnter.getReqObject();
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("key", APP_KEY);
        map.add("type", req.getType());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        NewsRsp newsRsp = this.restTemplate.postForObject(apiUrl,request,NewsRsp.class);
        log.info(newsRsp.toString());
        return new DataResult<>();
    }
}
