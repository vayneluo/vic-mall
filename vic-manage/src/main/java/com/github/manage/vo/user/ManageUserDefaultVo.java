package com.github.manage.vo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.manage.result.dtos.rsp.RspData;
import com.github.manage.vo.RoleVo;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.vo.user
 * @Description: 后台用户基础信息
 * @Author: Vayne.Luo
 * @date 2019/01/30
 */
@Data
public class ManageUserDefaultVo extends RspData{

    private static final long serialVersionUID = 5130159076488218137L;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    @JsonIgnore
    private String password;

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

    /** 角色列表**/
    private List<RoleDetailVo> roleVoList;
}
