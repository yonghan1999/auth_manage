package com.han.auth.configuration.security;


public class AuthenticationBean {
    private String username;
    private String password;
    private boolean remember;

    public String getUsername() {
        return username;
    }

    public AuthenticationBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

}
