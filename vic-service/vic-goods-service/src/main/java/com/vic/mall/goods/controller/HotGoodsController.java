package com.vic.mall.goods.controller;

import com.vic.goods.api.hot.IHotGoodsWebService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: vic-mall
 * @Package: com.vic.mall.goods.controller
 * @Description: 热卖商品Controller
 * @Author: Vayne.Luo
 * @date 2019/03/01
 */
@RestController
public class HotGoodsController implements IHotGoodsWebService{

    /**
     * 查询最新热卖的商品
     * @return 热卖商品列表
     */
    @Override
    @GetMapping(value = "/vic/goods/hots")
    public String queryHotGoodsList() {
        return "this is hot goods";
    }
}
