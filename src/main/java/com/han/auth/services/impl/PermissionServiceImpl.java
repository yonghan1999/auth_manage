package com.han.auth.services.impl;

import com.github.pagehelper.PageHelper;
import com.han.auth.entity.App;
import com.han.auth.entity.Role;
import com.han.auth.mapper.AppMapper;
import com.han.auth.mapper.AppRoleMapper;
import com.han.auth.mapper.RoleMapper;
import com.han.auth.mapper.UserRoleMapper;
import com.han.auth.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final AppMapper appMapper;

    private final RoleMapper roleMapper;

    private final AppRoleMapper appRoleMapper;

    private final UserRoleMapper userRoleMapper;

    @Autowired
    public PermissionServiceImpl(AppMapper appMapper, RoleMapper roleMapper, AppRoleMapper appRoleMapper, UserRoleMapper userRoleMapper) {
        this.appMapper = appMapper;
        this.roleMapper = roleMapper;
        this.appRoleMapper = appRoleMapper;
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<App> getAppList(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return appMapper.listAll();
    }

    @Override
    public void addApp(App app) {
        appMapper.insert(app);
    }

    @Override
    public void deleteApp(int id) {
        appMapper.deleteByPrimaryKey(id);
        appRoleMapper.deleteByAppid(id);
    }

    @Override
    public void editApp(App app) {
        appMapper.updateByPrimaryKeySelective(app);
    }

    @Override
    public List<Role> getAppRoleList(int appId) {
        return roleMapper.getByAppId(appId);
    }

    @Override
    public void addRole(Role r) {
        roleMapper.insert(r);
    }

    @Override
    public void deleteRole(int id) {
        roleMapper.deleteByPrimaryKey(id);
        userRoleMapper.deleteByRoleId(id);
    }

    @Override
    public void editRole(Role r) {
        roleMapper.updateByPrimaryKeySelective(r);
    }
}
