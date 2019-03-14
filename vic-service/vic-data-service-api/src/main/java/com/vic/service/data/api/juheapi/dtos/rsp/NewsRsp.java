package com.vic.service.data.api.juheapi.dtos.rsp;

import com.vic.common.base.result.dtos.rsp.RspData;
import lombok.Data;

import java.util.Date;

/**
 * @classname: NewsRsp
 * @description: 新闻返回包装
 * @author: Vayne.Luo
 * @date 2019/3/13 16:47
 */
@Data
public class NewsRsp extends RspData{

    private static final long serialVersionUID = 8090098662112541682L;

    /** 唯一编码 */
    private String uniquekey;

    /** 新闻标题 */
    private String title;

    /** 发布时间 */
    private String date;

    /** 新闻分类 */
    private String category;

    /** 作者名称 */
    private String author_name;

    /** 新闻链接 */
    private String url;

    /** 缩略图1 */
    private String thumbnail_pic_s;

    /** 缩略图2 */
    private String thumbnail_pic_s02;

    /** 缩略图3 */
    private String thumbnail_pic_s03;

}
