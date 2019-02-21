package com.github.manage.social.qq.api;

import com.github.manage.social.qq.model.QQUserInfo;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.social.qq.api
 * @Description: qq用户信息接口
 * @Author: Vayne.Luo
 * @date 2018/12/19
 */
public interface QQ {

    QQUserInfo getUserInfo();
}
