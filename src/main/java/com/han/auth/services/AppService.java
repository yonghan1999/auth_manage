package com.han.auth.services;

import com.han.auth.entity.App;

import java.util.List;

public interface AppService {
    List<App> getAppList(int pageIndex, int pageSize);

    void addApp(App app);
}
