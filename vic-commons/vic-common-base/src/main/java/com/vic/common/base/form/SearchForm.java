package com.vic.common.base.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.form
 * @Description: 查询表单
 * @Author: Vayne.Luo
 * @date 2019/01/29
 */
@Data
public class SearchForm extends BaseForm {

    private static final long serialVersionUID = -9218053938242059294L;

    /** 当前页数*/
    @Min(value = 1)
    private int currentPage;

    /** 每页条数*/
    @Max(value = 100)
    private int pageSize;;
}
