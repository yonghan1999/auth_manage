package com.han.auth.configuration.security;

import com.han.auth.base.SystemCode;
import com.han.auth.configuration.property.SystemConfig;
import com.han.auth.entity.Role;
import com.han.auth.utils.JwtTokenUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        if(null == tokenHeader || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
            String appName = JwtTokenUtils.getAppName(token);
            if (appName == null || !appName.equals(SystemConfig.DASHBOARD_NAME)) {
                filterChain.doFilter(request, response);
                return;
            }
            String username = JwtTokenUtils.getUserName(token);
            List<Role> roleList = JwtTokenUtils.getUserRole(token);
            List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
            roleList.forEach(item -> {
                roles.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return item.getName();
                    }
                });
            });
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, roles);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        } catch (Exception e) {
            logger.error(SystemCode.AccessTokenError.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
