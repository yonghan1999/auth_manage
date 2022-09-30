package com.han.auth.controller;

import com.han.auth.base.RestResponse;
import com.han.auth.base.annotation.AppName;
import com.han.auth.base.annotation.CurrentUser;
import com.han.auth.entity.User;
import com.han.auth.response.user.UserInfoResponse;
import com.han.auth.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserRoleService userRoleService;



}
