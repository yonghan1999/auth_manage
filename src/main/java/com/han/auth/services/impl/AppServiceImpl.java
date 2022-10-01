package com.han.auth.services.impl;

import com.github.pagehelper.PageHelper;
import com.han.auth.entity.App;
import com.han.auth.entity.Role;
import com.han.auth.mapper.AppMapper;
import com.han.auth.mapper.RoleMapper;
import com.han.auth.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final AppMapper appMapper;

    private final RoleMapper roleMapper;

    @Autowired
    public AppServiceImpl(AppMapper appMapper, RoleMapper roleMapper) {
        this.appMapper = appMapper;
        this.roleMapper = roleMapper;
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
    }

    @Override
    public void editApp(App app) {
        appMapper.updateByPrimaryKeySelective(app);
    }

    @Override
    public List<Role> getAppRoleList(int appId) {
        return roleMapper.getByAppId(appId);
    }
}
