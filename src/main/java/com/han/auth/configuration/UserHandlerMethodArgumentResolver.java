package com.han.auth.configuration;

import com.han.auth.base.annotation.CurrentUser;
import com.han.auth.entity.User;
import com.han.auth.utils.JwtTokenUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class) && User.class == parameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String tokenHeader = nativeWebRequest.getHeader(JwtTokenUtils.TOKEN_HEADER);
        if(tokenHeader == null) {
            return null;
        }
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        User user = new User();
        user.setId(JwtTokenUtils.getUserId(token));
        user.setUsername(JwtTokenUtils.getUserName(token));
        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);
        user.setIsEnable(true);
        return user;
    }
}
