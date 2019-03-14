package com.vic.mini.common.form;

import com.vic.common.base.form.BaseForm;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @classname: JuheApiForm
 * @description: 聚合数据API
 * @author: Vayne.Luo
 * @date 2019/3/13 15:25
 */
@Data
public class JuheApiForm extends BaseForm{

    private static final long serialVersionUID = -4364531678456485433L;

    /** 类型
     * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)，
     * junshi(军事),keji(科技),caijing(财经),shishang(时尚)
     */
    @NotBlank(message = "类型不能为空")
    private String type;
}
