package com.han.auth.controller;

import com.han.auth.base.RestResponse;
import com.han.auth.entity.App;
import com.han.auth.entity.Role;
import com.han.auth.request.permission.AddApp;
import com.han.auth.request.permission.AddRole;
import com.han.auth.response.permission.AppInfo;
import com.han.auth.response.permission.RoleInfo;
import com.han.auth.services.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private static final int pageSize = 10;

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService appService) {
        this.permissionService = appService;
    }

    @GetMapping("/app/list/{pageIndex}")
    public RestResponse<List<AppInfo>> appList(@PathVariable int pageIndex) {
        List<App> appList = permissionService.getAppList(pageIndex,pageSize);
        List<AppInfo> appInfoList = new ArrayList<AppInfo>();
        for (App app : appList) {
            AppInfo appInfo = new AppInfo();
            BeanUtils.copyProperties(app,appInfo);
            appInfoList.add(appInfo);
        }
        return RestResponse.ok(appInfoList);
    }

    @PostMapping("/app/add")
    public RestResponse<AppInfo> addApp(@RequestBody AddApp addApp) {
        addApp.setId(null);
        App app = new App();
        BeanUtils.copyProperties(addApp,app);
        permissionService.addApp(app);
        AppInfo appInfo = new AppInfo();
        BeanUtils.copyProperties(app,appInfo);
        return RestResponse.ok(appInfo);
    }

    @DeleteMapping("/app/{id}")
    public RestResponse<Boolean> deleteApp(@PathVariable int id) {
        permissionService.deleteApp(id);
        return RestResponse.ok(true);
    }

    @PutMapping("/app/edit")
    public RestResponse<AppInfo> editApp(@RequestBody AddApp editApp) {
        App app = new App();
        BeanUtils.copyProperties(editApp,app);
        permissionService.editApp(app);
        AppInfo appInfo = new AppInfo();
        BeanUtils.copyProperties(app,appInfo);
        return RestResponse.ok(appInfo);
    }

    @GetMapping("/role/list/{appId}")
    public RestResponse<List<RoleInfo>> appRoleList(@PathVariable int appId) {
        List<Role> roleList = permissionService.getAppRoleList(appId);
        List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();
        for (Role role : roleList) {
            RoleInfo roleInfo = new RoleInfo();
            BeanUtils.copyProperties(role, roleInfo);
            roleInfoList.add(roleInfo);
        }
        return RestResponse.ok(roleInfoList);
    }

    @PostMapping("/role/add")
    public RestResponse<RoleInfo> addRole(@RequestBody AddRole role) {
        role.setAppId(null);
        Role r = new Role();
        BeanUtils.copyProperties(role, r);
        permissionService.addRole(r);
        RoleInfo roleInfo = new RoleInfo();
        BeanUtils.copyProperties(r, roleInfo);
        return RestResponse.ok(roleInfo);
    }

    @DeleteMapping("/role/{id}")
    public RestResponse<Boolean> deleteRole(@PathVariable int id) {
        permissionService.deleteRole(id);
        return RestResponse.ok(true);
    }

    @PutMapping("/role/edit")
    public RestResponse<RoleInfo> editRole(@RequestBody AddRole role) {
        Role r = new Role();
        BeanUtils.copyProperties(role, r);
        permissionService.editRole(r);
        RoleInfo roleInfo = new RoleInfo();
        BeanUtils.copyProperties(r, roleInfo);
        return RestResponse.ok(roleInfo);
    }
}