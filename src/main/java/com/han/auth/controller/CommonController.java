package com.han.auth.controller;

import com.han.auth.base.RestResponse;
import com.han.auth.utils.JwtTokenUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/common")
@RestController
public class CommonController {

    @PostMapping("/token/verify")
    public RestResponse<Boolean> tokenVerification(String token) {
        boolean valid = JwtTokenUtils.valid(token);
        return RestResponse.ok(valid);
    }

}
