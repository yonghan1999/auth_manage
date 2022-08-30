package com.han.auth.entity;

import java.util.Date;

public class App {
    private Integer id;

    private String name;

    private String currentVersion;

    private String currentCode;

    private String supportVersion;

    private String supportCode;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim();
    }

    public String getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode == null ? null : currentCode.trim();
    }

    public String getSupportVersion() {
        return supportVersion;
    }

    public void setSupportVersion(String supportVersion) {
        this.supportVersion = supportVersion == null ? null : supportVersion.trim();
    }

    public String getSupportCode() {
        return supportCode;
    }

    public void setSupportCode(String supportCode) {
        this.supportCode = supportCode == null ? null : supportCode.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}