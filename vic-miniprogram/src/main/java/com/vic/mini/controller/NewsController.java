package com.vic.mini.controller;

import com.vic.common.base.result.GeneralResult;
import com.vic.mini.common.form.JuheApiForm;
import com.vic.mini.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @classname: NewsController
 * @description: 新闻头条
 * @author: Vayne.Luo
 * @date 2019/3/13 14:10
 */
@RestController
@RequestMapping(value = "/vic/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    /**
     * @description: 查询最新新闻
     * @author Vayne.luo
     * @date 2019/3/13 15:07　
     */
    @PostMapping(value = "/latest")
    public GeneralResult queryLatestNewsList(@RequestBody JuheApiForm apiForm){
        return newsService.queryLatestNewsList(apiForm);
    }
}
