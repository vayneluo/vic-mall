package com.github.manage.entity.manage;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_role")
public class SysRole {
    /**
     * 系统角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统角色描述
     */
    private String description;

    /**
     * 系统角色名称
     */
    private String name;

    /**
     * 系统角色状态[0.删除，1.正常]
     */
    private Integer state;

    /**
     * 添加时间
     */
    @Column(name = "create_time",insertable=false,updatable=false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time",insertable=false)
    private Date updateTime;
    /**
     * 获取系统角色ID
     *
     * @return id - 系统角色ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置系统角色ID
     *
     * @param id 系统角色ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取系统角色描述
     *
     * @return description - 系统角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置系统角色描述
     *
     * @param description 系统角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取系统角色名称
     *
     * @return name - 系统角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置系统角色名称
     *
     * @param name 系统角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取系统角色状态[0.删除，1.正常]
     *
     * @return state - 系统角色状态[0.删除，1.正常]
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置系统角色状态[0.删除，1.正常]
     *
     * @param state 系统角色状态[0.删除，1.正常]
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取修改时间
     *
     * @return create_time - 修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置修改时间
     *
     * @param createTime 修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取添加时间
     *
     * @return update_time - 添加时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置添加时间
     *
     * @param updateTime 添加时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}