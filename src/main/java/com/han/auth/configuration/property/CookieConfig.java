package com.han.auth.configuration.property;

public class CookieConfig {

    public static String getName() {
        return "auth_config";
    }

    public static Integer getInterval() {
        return 30 * 24 * 60 * 60;
    }
}
