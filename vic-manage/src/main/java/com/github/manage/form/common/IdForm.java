package com.github.manage.form.common;

import com.github.manage.common.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.form.common
 * @Description: 基础ID表单
 * @Author: Vayne.Luo
 * @date 2019/01/30
 */
@Data
public class IdForm extends BaseForm{

    private static final long serialVersionUID = -7644186012402434986L;

    @NotNull
    private Long id;
}
