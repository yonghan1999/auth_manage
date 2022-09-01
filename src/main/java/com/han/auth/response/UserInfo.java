package com.han.auth.response;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {
    private Integer userId;
    private String username;
    private String realName;
    private String avatar;
    private Role roles;

    public Integer getUserId() {
        return userId;
    }

    public UserInfo setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public UserInfo setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserInfo setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public Role getRoles() {
        return roles;
    }

    public UserInfo setRoles(List<com.han.auth.entity.Role> roles) {
        // TODO 和前端适配多角色
        this.roles = new Role("User","user");
        return this;
    }
}
