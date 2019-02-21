package com.github.manage.vo.user;

import com.github.manage.result.dtos.rsp.RspData;
import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo.user
 * @Description: 后台用户列表VO
 * @Author: Vayne.Luo
 * @date 2019/01/23
 */
@Data
public class ManageUserListVo extends RspData{

    private static final long serialVersionUID = 8993247616366755463L;

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 添加时间
     */
    private Date createTime;
}
