package com.github.manage.entity.manage;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_log")
public class SysLog {
    /**
     * 日志ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作用户
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 日志类型
     */
    @Column(name = "LOG_TYPE")
    private Integer logType;

    /**
     * 耗时
     */
    @Column(name = "TIME")
    private Long time;

    /**
     * 操作者IP
     */
    @Column(name = "IP")
    private String ip;

    /**
     * 创建时间
     */
    @Column(name = "create_time",insertable=false,updatable=false)
    private Date createTime;

    /**
     * 操作地点
     */
    private String location;

    /**
     * 操作内容
     */
    @Column(name = "OPERATION")
    private String operation;

    /**
     * 操作方法
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * 方法参数
     */
    @Column(name = "PARAMS")
    private String params;

    /**
     * 获取日志ID
     *
     * @return ID - 日志ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置日志ID
     *
     * @param id 日志ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作用户
     *
     * @return USERNAME - 操作用户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作用户
     *
     * @param username 操作用户
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取日志类型
     *
     * @return LOG_TYPE - 日志类型
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * 设置日志类型
     *
     * @param logType 日志类型
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * 获取耗时
     *
     * @return TIME - 耗时
     */
    public Long getTime() {
        return time;
    }

    /**
     * 设置耗时
     *
     * @param time 耗时
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 获取操作者IP
     *
     * @return IP - 操作者IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置操作者IP
     *
     * @param ip 操作者IP
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
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
     * 获取操作地点
     *
     * @return location - 操作地点
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置操作地点
     *
     * @param location 操作地点
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 获取操作内容
     *
     * @return OPERATION - 操作内容
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置操作内容
     *
     * @param operation 操作内容
     */
    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    /**
     * 获取操作方法
     *
     * @return METHOD - 操作方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置操作方法
     *
     * @param method 操作方法
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取方法参数
     *
     * @return PARAMS - 方法参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置方法参数
     *
     * @param params 方法参数
     */
    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
}