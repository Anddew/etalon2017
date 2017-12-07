package com.netcracker.project.controller;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.bean.user.UserViewModelFactory;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.exception.RegistrationException;
import com.netcracker.project.servicefront.UserRegistrationService;
import com.netcracker.project.servicefront.UserRegistrationServiceFactory;
import com.netcracker.project.validation.Validator;
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

    @Autowired
    protected Validator validator;

    private static final String REGISTER_VIEW_PATH = "register";
    private static final String REGISTER_MAPPING = "register";
    private static final String ROLE_PARAMETER_NAME = "role";

//    private static final String USERNAME_PARAMETER_NAME = "username";
//    private static final String PASSWORD_PARAMETER_NAME = "password";
//    private static final String EMAIL_PARAMETER_NAME = "email";
//    private static final String FIRST_NAME_PARAMETER_NAME = "firstname";
//    private static final String LAST_NAME_PARAMETER_NAME = "lastname";


    @RequestMapping(value = REGISTER_MAPPING, method = RequestMethod.GET)
    public ModelAndView register() {
        System.out.println("validator - " + validator);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(REGISTER_VIEW_PATH);
        return modelAndView;
    }

    @RequestMapping(value = REGISTER_MAPPING, method = RequestMethod.POST)
    public void register(@RequestBody Map<String,String> userParameters, HttpServletRequest request, HttpServletResponse response) throws RegistrationException {
        UserRole role = UserRole.valueOf(userParameters.get(ROLE_PARAMETER_NAME).toUpperCase());
        if(role == null) {
            System.out.println("Unknown user role - " + role);
            throw new RegistrationException("Unknown user role - " +role);
        }
        UserRegistrationService userRegistrationService = UserRegistrationServiceFactory.getRegistrationService(role);
        UserViewModel userViewModel = UserViewModelFactory.getViewModel(role);
        userRegistrationService.register(userViewModel, userParameters);
    }


}
