package com.han.auth.configuration.security;

import com.han.auth.configuration.property.TokenConfig;
import com.han.auth.utils.JsonUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import static com.han.auth.configuration.property.SystemConfig.LOGIN_ENTRY_POINTER;

public class RestLoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String defaultAppName = "com.han.auth";

    protected RestLoginAuthenticationFilter() {
        super(new AntPathRequestMatcher(LOGIN_ENTRY_POINTER, "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        UsernamePasswordAuthenticationToken authRequest;
        try (InputStream is = request.getInputStream()) {
            AuthenticationBean authenticationBean = JsonUtil.toJsonObject(is, AuthenticationBean.class);
            assert authenticationBean != null;
            authRequest = new UsernamePasswordAuthenticationToken(authenticationBean.getUsername(), authenticationBean.getPassword());
        } catch (IOException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
//        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
        AuthenticationDetail details = new AuthenticationDetail();
        String appName = request.getHeader(TokenConfig.getAppNameFieldName());
        details.setAppName(Objects.requireNonNullElse(appName, defaultAppName));
        authRequest.setDetails(details);
    }
}
