package com.github.manage.vo;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo
 * @Description: 按钮vo
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
@Data
public class ButtonVo extends RspData{

    private static final long serialVersionUID = -4218945609640199524L;

    private Long id;

    private String resources;

    private String title;

    public ButtonVo(Long id, String resources, String title) {
        this.id = id;
        this.resources = resources;
        this.title = title;
    }

}
