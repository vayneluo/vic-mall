package com.github.manage.entity.manage;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_dept")
public class SysDept {
    /**
     * 部门id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 上级部门
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 部门排序
     */
    private Integer level;

    /**
     * 部门描述
     */
    private String describe;

    /**
     * 创建时间
     */
    @Column(name = "create_time",insertable=false,updatable=false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time",insertable=false)
    private Date updateTime;

    /**
     * 获取部门id
     *
     * @return id - 部门id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置部门id
     *
     * @param id 部门id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取上级部门
     *
     * @return parent_id - 上级部门
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置上级部门
     *
     * @param parentId 上级部门
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取部门排序
     *
     * @return level - 部门排序
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置部门排序
     *
     * @param level 部门排序
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取部门描述
     *
     * @return describe - 部门描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置部门描述
     *
     * @param describe 部门描述
     */
    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}