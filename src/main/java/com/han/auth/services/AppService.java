package com.han.auth.services;

import com.han.auth.entity.App;
import com.han.auth.entity.Role;

import java.util.List;

public interface AppService {
    List<App> getAppList(int pageIndex, int pageSize);

    void addApp(App app);

    void deleteApp(int id);

    void editApp(App app);

    List<Role> getAppRoleList(int appId);
}
