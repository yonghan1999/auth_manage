package com.han.auth.configuration.property;

public class TokenConfig {

    public static String getTokenHeaderName() {
        return "Authorization";
    }

    public static String getName() {
        return "auth_config";
    }

    public static Integer getInterval() {
        return 30 * 24 * 60 * 60;
    }

    public static String getAppNameFieldName() {
        return "App-Name";
    }
}
