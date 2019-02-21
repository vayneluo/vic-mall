package com.vic.common.base.result;

import com.vic.common.base.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.result
 * @Description: 通用返回结果集
 * @Author: Vayne.Luo
 * @date 2019/01/24
 */
@Data
public class GeneralResult implements Serializable{

    private static final long serialVersionUID = -1723376759576654464L;

    private Result result;

    public GeneralResult(){
        this.result = Result.success();
    }

    public static GeneralResult error(BusinessException businessException){
        GeneralResult generalResult = new GeneralResult();
        generalResult.setResult(Result.error(businessException.getCode(),businessException.getMessage(),null));
        return generalResult;
    }
}
