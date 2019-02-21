package com.github.manage.repository.manage;

import com.github.manage.common.mapper.MyMapper;
import com.github.manage.entity.manage.ManageUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManageUserMapper extends MyMapper<ManageUser> {

}