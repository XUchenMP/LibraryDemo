package com.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    /**
     * 用户名称
     */
    private String nickname;
    /**
     * 用户名
     */
    private String username;
    /**
     * 角色
     */
    private List<Role> roles;
    /**
     * 权限
     */
    private List<String> accesses;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> getAccesses() {
        return accesses;
    }

    public void setAccesses(List<String> accesses) {
        this.accesses = accesses;
    }
}
