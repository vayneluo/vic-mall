package com.github.manage.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.common.mapper
 * @Description: 自定义实现mapper
 * @Author: Vayne.Luo
 * @date 2018/12/18
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
