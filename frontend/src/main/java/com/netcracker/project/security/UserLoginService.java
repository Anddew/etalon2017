package com.netcracker.project.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserLoginService {

    void authenticateUserAndSetSession(String username, String password, String rememberMe, HttpServletRequest request, HttpServletResponse response);

}