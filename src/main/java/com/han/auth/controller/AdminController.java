package com.han.auth.controller;

import com.han.auth.base.RestResponse;
import com.han.auth.base.annotation.AppName;
import com.han.auth.base.annotation.CurrentUser;
import com.han.auth.entity.User;
import com.han.auth.response.UserInfo;
import com.han.auth.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRoleService userRoleService;


    @GetMapping("/userinfo")
    public RestResponse<UserInfo> getUserInfo(@CurrentUser User user, @AppName String appName) {
        UserInfo info = new UserInfo();
        info.setUserId(user.getId())
                .setUsername(user.getUsername())
                .setAvatar("https://q1.qlogo.cn/g?b=qq&nk=190848757&s=640")
                .setRealName(user.getUsername())
                .setRoles(userRoleService.getUserRole(user, appName));
        System.out.println(user.toString());
        return RestResponse.ok(info);
    }
}
