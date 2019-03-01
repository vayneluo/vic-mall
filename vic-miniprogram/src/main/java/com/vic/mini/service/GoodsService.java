package com.vic.mini.service;

import com.vic.goods.api.hot.IHotGoodsWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: vic-mall
 * @Package: com.vic.mini.service
 * @Description: 商品服务类
 * @Author: Vayne.Luo
 * @date 2019/03/01
 */
@Service
public class GoodsService {

    @Autowired
    IHotGoodsWebService hotGoodsWebService;

    public String queryHotGoodsList() {
        return hotGoodsWebService.queryHotGoodsList();
    }
}
