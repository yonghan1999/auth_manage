package com.han.auth.controller;

import com.han.auth.base.RestResponse;
import com.han.auth.entity.App;
import com.han.auth.request.permission.AddApp;
import com.han.auth.request.permission.AddRole;
import com.han.auth.request.permission.ListAppRequest;
import com.han.auth.request.user.RegisterByEmailRequest;
import com.han.auth.response.permission.AppInfo;
import com.han.auth.response.user.RegisterResponse;
import com.han.auth.services.AppService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleInfo;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private static final int pageSize = 10;

    private final AppService appService;

    @Autowired
    public PermissionController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/app/list/{pageIndex}")
    public RestResponse<List<AppInfo>> appList(@PathVariable int pageIndex) {
        // TODO list all app
        List<App> appList = appService.getAppList(pageIndex,pageSize);
        List<AppInfo> appInfoList = new ArrayList<AppInfo>();
        for (App app : appList) {
            AppInfo appInfo = new AppInfo();
            BeanUtils.copyProperties(app,appInfo);
            appInfoList.add(appInfo);
        }
        return RestResponse.ok(appInfoList);
    }

    @PostMapping("/app/add")
    public RestResponse<Boolean> addApp(@RequestBody AddApp appInfo) {
        // TODO add app
        return null;
    }

    @DeleteMapping("/app/{id}")
    public RestResponse<Boolean> deleteApp(@PathVariable int id) {
        // TODO delete app
        return null;
    }

    @PutMapping("/app/edit")
    public RestResponse<AddApp> editApp(@RequestBody AddApp appInfo) {
        // TODO edit app
        return null;
    }

    @GetMapping("/role/list/{appId}")
    public RestResponse<RoleInfo> appRoleList() {
        // TODO list all app
        return null;
    }

    @PostMapping("/role/add")
    public RestResponse<Boolean> addRole(@RequestBody AddRole role) {
        // TODO add role
        return null;
    }

    @DeleteMapping("/role/{id}")
    public RestResponse<Boolean> deleteRole(@PathVariable int id) {
        // TODO delete role
        return null;
    }

    @PutMapping("/role/edit")
    public RestResponse<AddRole> editRole(@RequestBody AddRole role) {
        // TODO edit role
        return null;
    }
}