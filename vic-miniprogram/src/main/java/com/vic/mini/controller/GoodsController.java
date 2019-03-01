package com.vic.mini.controller;

import com.vic.mini.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: vic-mall
 * @Package: com.vic.mini.controller
 * @Description: 商品Controller
 * @Author: Vayne.Luo
 * @date 2019/03/01
 */
@RestController
@RequestMapping(value = "/vic/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/hots")
    private String queryHotGoodsList(){
        return goodsService.queryHotGoodsList();
    }
}
