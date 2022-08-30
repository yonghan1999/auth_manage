package com.han.auth.services;

import com.han.auth.entity.Role;
import com.han.auth.entity.User;

import java.util.List;

public interface UserRoleService {
    List<Role> getUserRole(User user,String appName);
    List<String> getUserRoleName(User user,String appName);
    List<Role> getAllRole();
    int setUserRole(User user, Role role);
}
