package com.netcracker.project.security;

import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface LoginUserService {

    // TODO: 29.11.2017  
    void authenticateUserAndSetSession(String username, String password, HttpServletRequest request, HttpServletResponse response);

    // TODO: 29.11.2017  
    String resolveHomeView(List<GrantedAuthority> authorities);
}