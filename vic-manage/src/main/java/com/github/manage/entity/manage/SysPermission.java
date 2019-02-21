package com.github.manage.entity.manage;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_permission")
public class SysPermission {
    /**
     * 权限唯一ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 上级ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 权限资源 
     */
    private String resources;

    /**
     * 资源名称
     */
    private String title;

    /**
     * 资源图标
     */
    private String icon;

    /**
     * 类型，menu或者button
     */
    @Column(name = "perm_type")
    private Integer permType;

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
     * 权限描述
     */
    private String description;

    /**
     * 获取权限唯一ID
     *
     * @return id - 权限唯一ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置权限唯一ID
     *
     * @param id 权限唯一ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取上级ID
     *
     * @return parent_id - 上级ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置上级ID
     *
     * @param parentId 上级ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取权限资源 
     *
     * @return resources - 权限资源 
     */
    public String getResources() {
        return resources;
    }

    /**
     * 设置权限资源 
     *
     * @param resources 权限资源 
     */
    public void setResources(String resources) {
        this.resources = resources == null ? null : resources.trim();
    }

    /**
     * 获取资源名称
     *
     * @return title - 资源名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置资源名称
     *
     * @param title 资源名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取资源图标
     *
     * @return icon - 资源图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置资源图标
     *
     * @param icon 资源图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取类型，menu或者button
     *
     * @return perm_type - 类型，menu或者button
     */
    public Integer getPermType() {
        return permType;
    }

    /**
     * 设置类型，menu或者button
     *
     * @param permType 类型，menu或者button
     */
    public void setPermType(Integer permType) {
        this.permType = permType;
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

    /**
     * 获取权限描述
     *
     * @return description - 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置权限描述
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}