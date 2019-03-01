package com.vic.goods.api.hot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ProjectName: vic-mall
 * @Package: com.vic.goods.api.hot
 * @Description: 热卖商品API接口
 * @Author: Vayne.Luo
 * @date 2019/03/01
 */
@FeignClient(name = "vic-goods-service")
public interface IHotGoodsWebService {

    /**
     * 查询热卖商品列表
     * @return
     */
    @GetMapping(value = "/vic/goods/hots")
    String queryHotGoodsList();
}
