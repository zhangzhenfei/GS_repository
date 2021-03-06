package com.glacier.permission.entity;

import java.io.Serializable;
import java.util.Date;

import com.glacier.permission.entity.util.UserBuiltin;
import com.glacier.permission.entity.util.UserStatus;

public class User implements Serializable {

    private static final long serialVersionUID = -153663806132372652L;

    private String userId;

    private String username;

    private String password;

    private String salt;

    /**
     * 枚举：用户状态
     */
    private UserStatus status;

    /**
     * 枚举：用户是否内置
     */
    private UserBuiltin builtin;

    private String email;

    private String userImage;

    private String remark;

    private Date lastLoginTime;

    private String lastLoginIpAddress;

    private String creater;

    private Date createTime;

    private String depId;

    public User() {
    }

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserBuiltin getBuiltin() {
        return builtin;
    }

    public void setBuiltin(UserBuiltin builtin) {
        this.builtin = builtin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIpAddress() {
        return lastLoginIpAddress;
    }

    public void setLastLoginIpAddress(String lastLoginIpAddress) {
        this.lastLoginIpAddress = lastLoginIpAddress;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getBuiltin() == null ? other.getBuiltin() == null : this.getBuiltin().equals(other.getBuiltin()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getUserImage() == null ? other.getUserImage() == null : this.getUserImage().equals(other.getUserImage()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
                && (this.getLastLoginIpAddress() == null ? other.getLastLoginIpAddress() == null : this.getLastLoginIpAddress().equals(other.getLastLoginIpAddress()))
                && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getDepId() == null ? other.getDepId() == null : this.getDepId().equals(other.getDepId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBuiltin() == null) ? 0 : getBuiltin().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getUserImage() == null) ? 0 : getUserImage().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getLastLoginIpAddress() == null) ? 0 : getLastLoginIpAddress().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDepId() == null) ? 0 : getDepId().hashCode());
        return result;
    }
}