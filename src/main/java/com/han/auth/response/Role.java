package com.han.auth.response;

class Role {
    private String roleName;
    private String value;

    public Role(String roleName, String value) {
        this.roleName = roleName;
        this.value = value;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Role setValue(String value) {
        this.value = value;
        return this;
    }
}