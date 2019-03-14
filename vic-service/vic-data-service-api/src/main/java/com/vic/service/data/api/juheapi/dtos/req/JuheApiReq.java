package com.vic.service.data.api.juheapi.dtos.req;

import com.vic.common.base.result.dtos.req.base.ReqObject;
import lombok.Data;

/**
 * @classname: JuheApiReq
 * @description: 聚合API请求参数
 * @author: Vayne.Luo
 * @date 2019/3/13 16:24
 */
@Data
public class JuheApiReq extends ReqObject{

    private static final long serialVersionUID = -5911160599874827088L;

    /** 类型
     * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)，
     * junshi(军事),keji(科技),caijing(财经),shishang(时尚)
     */
    private String type;
}
