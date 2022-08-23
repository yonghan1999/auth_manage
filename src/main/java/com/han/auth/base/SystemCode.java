package com.han.auth.base;

public enum SystemCode {

    /**
     * OK
     */
    OK(1, "成功"),


    /*---------------------------- http code -----------------------------------*/
    /**
     * AccessTokenError
     */
    AccessTokenError(400, "用户登录令牌失效"),
    /**
     * UNAUTHORIZED
     */
    UNAUTHORIZED(401, "用户未登录"),
    /**
     * UNAUTHORIZED
     */
    AuthError(402, "用户名或密码错误"),
    /**
     * InnerError
     */
    InnerError(500, "系统内部错误"),
    /**
     * ParameterValidError
     */
    ParameterValidError(501, "参数验证错误"),
    /**
     * AccessDenied
     */
    AccessDenied(502,"用户没有权限访问"),



    /*---------------------------- account err code -----------------------------------*/
    AccountError(1000,"账号出现错误"),
    AccountLocked(1001,"账号被锁定"),
    AccountExpired(1002,"账号过期"),




    UndefineError(9999,"未知的错误");


    int code;
    String message;

    SystemCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}