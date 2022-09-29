package com.han.auth.controller;


import com.han.auth.base.RestResponse;
import com.han.auth.base.annotation.CurrentUser;
import com.han.auth.entity.User;
import com.han.auth.request.user.RegisterByEmailRequest;
import com.han.auth.response.user.RefreshTokenResponse;
import com.han.auth.response.user.RegisterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public RestResponse<RegisterResponse> registerByEmail(RegisterByEmailRequest request) {
        // TODO
        return null;
    }

    @GetMapping("/token/refresh")
    public RestResponse<RefreshTokenResponse> refreshToken(@CurrentUser User currentUser) {
        // TODO
        return null;
    }
}
