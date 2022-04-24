package com.olliego.wiki.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author olliego
 * @since 2022-04-24
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建人
     */
    @TableField("create_people")
    private String createPeople;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    @TableField("modify_people")
    private String modifyPeople;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private LocalDateTime modifyTime;

    /**
     * 是否删除 0正常 1删除
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 登录名
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getModifyPeople() {
        return modifyPeople;
    }

    public void setModifyPeople(String modifyPeople) {
        this.modifyPeople = modifyPeople;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createPeople=" + createPeople +
                ", createTime=" + createTime +
                ", modifyPeople=" + modifyPeople +
                ", modifyTime=" + modifyTime +
                ", deleted=" + deleted +
                ", loginName=" + loginName +
                ", userName=" + userName +
                ", password=" + password +
                "}";
    }
}
