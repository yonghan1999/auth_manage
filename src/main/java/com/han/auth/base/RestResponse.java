package com.han.auth.base;

public class RestResponse<T> {
    private int code;
    private String type;
    private String message;
    private T result;

    public RestResponse(int code, String message, ResponseType type) {
        this.code = code;
        this.message = message;
        this.type = type.getName();
    }

    public RestResponse(int code, String message, T response, ResponseType type) {
        this.code = code;
        this.message = message;
        this.result = response;
        this.type = type.getName();
    }

    public static RestResponse fail(Integer code, String msg) {
        return new RestResponse<>(code, msg, ResponseType.ERROR);
    }

    public static RestResponse ok() {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), ResponseType.SUCCESS);
    }

    public static <F> RestResponse<F> ok(F response) {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response, ResponseType.SUCCESS);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public RestResponse<T> setType(String type) {
        this.type = type;
        return this;
    }
}