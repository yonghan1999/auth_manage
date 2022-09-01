package com.han.auth.base;

public enum ResponseType {
    SUCCESS("success"),
    ERROR("error"),
    WARNING("warning");


    private String name;

    ResponseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}