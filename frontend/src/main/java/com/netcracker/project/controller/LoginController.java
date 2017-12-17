package com.netcracker.project.controller;

import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.security.UserLoginService;
import com.netcracker.project.service.UserService;
import com.netcracker.project.validation.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class.getSimpleName());

    private static final String LOGIN_VIEW_PATH = "login";
    private static final String LOGIN_URL_PATTERN = "authorization";

    private static final String USERNAME_USER_PARAMETER = "username";
    private static final String PASSWORD_USER_PARAMETER = "password";
    private static final String REMEMBER_ME_PARAMETER = "rememberme";

    @Autowired
    private UserValidator validator;

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = LOGIN_URL_PATTERN, method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(LOGIN_VIEW_PATH);
        logger.debug("Show login page.");
        return modelAndView;
    }

    @RequestMapping(value = LOGIN_URL_PATTERN, method = RequestMethod.POST)
    public void login(@RequestBody Map<String,String> userParameters,
                      HttpServletRequest request,
                      HttpServletResponse response) {

        try {
            logger.debug("Processing authorization.");
            userLoginService.authenticateUserAndSetSession(
                    userParameters.get(USERNAME_USER_PARAMETER),
                    userParameters.get(PASSWORD_USER_PARAMETER),
                    userParameters.get(REMEMBER_ME_PARAMETER),
                    request,
                    response);
        } catch (BadCredentialsException e) {
            logger.error("Bad credentials.", e);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
