package com.netcracker.project.security.impl;

import com.netcracker.project.security.UserLoginService;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class UserLoginServiceImpl implements UserLoginService {

    private Logger logger = Logger.getLogger(UserLoginServiceImpl.class.getSimpleName());

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenBasedRememberMeServices rememberMeServices;


    public void authenticateUserAndSetSession(String username, String password, String rememberMe, HttpServletRequest request, HttpServletResponse response) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        if(Boolean.valueOf(rememberMe)) {
            logger.debug("Set remember me cookie for successfully authenticated user '" + username +"'.");
            rememberMeServices.onLoginSuccess(request, response, authenticatedUser);
        }
        logger.debug("Authentication and setting session completed for user '" + username + "'.");
    }

}