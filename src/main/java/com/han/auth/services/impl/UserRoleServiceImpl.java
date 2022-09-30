package com.han.auth.services.impl;

import com.han.auth.entity.*;
import com.han.auth.mapper.*;
import com.han.auth.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final UserRoleMapper userRoleMapper;
    private final AppMapper appMapper;
    private final AppRoleMapper appRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserMapper userMapper, RoleMapper roleMapper, UserRoleMapper userRoleMapper, AppMapper appMapper, AppRoleMapper appRoleMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
        this.appMapper = appMapper;
        this.appRoleMapper = appRoleMapper;
    }


    @Override
    public List<Role> getUserRole(User user, String appName) {
        List<Role> roleList = new ArrayList<>();
        App app = appMapper.getByName(appName);
        if (app == null) {
            return roleList;
        }
        List<AppRoleKey> appRoles = roleMapper.getByAppId(app.getId());
        List<Integer> roleIdList = appRoles.stream().map(AppRoleKey::getRoleId).collect(Collectors.toList());
        List<UserRoleKey> userRoleList = roleMapper.getUserRolesByUid(user.getId());
        userRoleList.forEach(item -> {
            if(roleIdList.contains(item.getRid())) {
                roleList.add(roleMapper.selectByPrimaryKey(item.getRid()));
            }
        });
        return roleList;
    }

    @Override
    public List<String> getUserRoleName(User user, String appName) {
        List<String> listRoleName = new ArrayList<>();
        List<Role> roleList = getUserRole(user, appName);
        roleList.forEach(item -> {
            listRoleName.add(item.getName());
        });
        return listRoleName;
    }

    @Override
    public List<Role> getAllRole() {
        return roleMapper.selectAll();
    }

    @Override
    public int setUserRole(User user, Role role) {
        UserRoleKey userRole = new UserRoleKey();
        userRole.setUid(user.getId());
        userRole.setRid(role.getId());
        userRoleMapper.insert(userRole);
        return 0;
    }
}
