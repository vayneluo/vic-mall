package com.github.manage.service.manage;

import com.github.manage.vo.RoleVo;
import com.github.manage.vo.user.RoleDetailVo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ProjectName: spring-cloud-examples
 * @Package: com.github.manage.service.manage
 * @Description: 用户角色服务接口
 * @Author: Vayne.Luo
 * @date 2019/01/18
 */
public interface SysRoleService {

    List<RoleVo> getRoleSetByUser(Long id);

    /**
     * 根据用户ID查询角色
     */
    List<RoleDetailVo> getRoleDetailById(Long id);
}
