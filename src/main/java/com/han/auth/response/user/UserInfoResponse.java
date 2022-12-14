package com.han.auth.response.user;


public class UserInfoResponse {
    private Integer userId;
    private String username;
    private String realName;
    private String avatar;

    public Integer getUserId() {
        return userId;
    }

    public UserInfoResponse setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserInfoResponse setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public UserInfoResponse setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserInfoResponse setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }
}
