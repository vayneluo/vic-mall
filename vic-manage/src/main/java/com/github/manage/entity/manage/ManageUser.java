package com.github.manage.entity.manage;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sys_user")
public class ManageUser {
    /**
     * 系统用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 账号
     */
    private String username;

    /**
     * 用户名称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

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
    @Column(name = "create_time",insertable=false,updatable=false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time",insertable=false)
    private Date updateTime;

    /**
     * 部门id
     */
    private Integer dept;

    /**
     * 获取系统用户ID
     *
     * @return id - 系统用户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置系统用户ID
     *
     * @param id 系统用户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取用户名称
     *
     * @return nickname - 用户名称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户名称
     *
     * @param nickname 用户名称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取邮箱
     *
     * @return mail - 邮箱
     */
    public String getMail() {
        return mail;
    }

    /**
     * 设置邮箱
     *
     * @param mail 邮箱
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
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
     * 获取部门id
     *
     * @return dept - 部门id
     */
    public Integer getDept() {
        return dept;
    }

    /**
     * 设置部门id
     *
     * @param dept 部门id
     */
    public void setDept(Integer dept) {
        this.dept = dept;
    }
}