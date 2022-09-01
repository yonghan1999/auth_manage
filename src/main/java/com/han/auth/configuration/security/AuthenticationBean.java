package com.han.auth.configuration.security;


public class AuthenticationBean {
    private String username;
    private String password;

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

}
