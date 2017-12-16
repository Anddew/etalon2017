package com.netcracker.project.controller;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.bean.user.UserViewModelFactory;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.exception.RegistrationException;
import com.netcracker.project.servicefront.UserRegistrationService;
import com.netcracker.project.servicefront.impl.UserRegistrationServiceFactory;
import com.netcracker.project.validation.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class RegisterController {

    private Logger logger = Logger.getLogger(RegisterController.class.getSimpleName());

    @Autowired
    private UserRegistrationServiceFactory userRegistrationServiceFactory;

    @Autowired
    protected UserValidator validator;

    private static final String REGISTER_VIEW_PATH = "register";
    private static final String REGISTER_URL_PATTERN = "register";
    private static final String ROLE_PARAMETER_NAME = "role";

    @RequestMapping(value = REGISTER_URL_PATTERN, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(REGISTER_VIEW_PATH);
        return modelAndView;
    }

    @RequestMapping(value = REGISTER_URL_PATTERN, method = RequestMethod.POST)
    public void register(@RequestBody Map<String,String> userParameters, HttpServletRequest request, HttpServletResponse response) {
        String roleParameter = userParameters.get(ROLE_PARAMETER_NAME);
        if(roleParameter == null) {
            logger.warn("Request parameter 'role' is null. Response HTTP code 400 - Bad request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserRole role = UserRole.valueOf(roleParameter.toUpperCase());
        if(role == null) {
            logger.warn("Request parameter 'role' is invalid, no matches. Response HTTP code 400 - Bad request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserRegistrationService userRegistrationService = userRegistrationServiceFactory.getRegistrationService(role);
        if(userRegistrationService == null) {
            logger.warn("Cannot find registration service for this role - " + role.toString() + ". Response HTTP code 400 - Bad request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserViewModel userViewModel = UserViewModelFactory.getViewModel(role);
        if(userViewModel == null) {
            logger.warn("Cannot find view model for this role - " + role.toString() + ". Response HTTP code 400 - Bad request.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try {
            userRegistrationService.register(userViewModel, userParameters);
            logger.info("User registration successful.");
        } catch (RegistrationException e) {
            logger.error("Cannot register user. Response HTTP code 400 - Bad request.", e);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
