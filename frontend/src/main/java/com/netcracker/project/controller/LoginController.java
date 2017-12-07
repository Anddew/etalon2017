package com.netcracker.project.controller;

import com.netcracker.project.security.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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

    private static final String USERNAME_USER_PARAMETER = "username";
    private static final String PASSWORD_USER_PARAMETER = "password";

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(error != null) {
            modelAndView.addObject("error", "Something going wrong.");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(@RequestBody Map<String,String> userParameters, HttpServletRequest request, HttpServletResponse response) {
        try {
            userLoginService.authenticateUserAndSetSession(userParameters.get(USERNAME_USER_PARAMETER), userParameters.get(PASSWORD_USER_PARAMETER), request, response);
        } catch (BadCredentialsException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }



}
