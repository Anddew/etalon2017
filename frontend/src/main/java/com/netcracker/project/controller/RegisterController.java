package com.netcracker.project.controller;

import com.netcracker.project.bean.user.UserViewModel;
import com.netcracker.project.bean.user.UserViewModelFactory;
import com.netcracker.project.entity.user.UserRole;
import com.netcracker.project.exception.RegistrationException;
import com.netcracker.project.servicefront.UserRegistrationService;
import com.netcracker.project.servicefront.impl.UserRegistrationServiceFactory;
import com.netcracker.project.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private UserRegistrationServiceFactory userRegistrationServiceFactory;

    @Autowired
    protected Validator validator;

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
        Iterator<String> it = userParameters.keySet().iterator();
        while (it.hasNext()) {
            String elem = it.next();
            System.out.println(elem + " - " + userParameters.get(elem));
        }

        String roleParameter = userParameters.get(ROLE_PARAMETER_NAME);
        System.out.println("1 - " + roleParameter);
        if(roleParameter == null) {
            setResponseStatus(response, HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserRole role = UserRole.valueOf(roleParameter.toUpperCase());
        System.out.println("2 - " + role);
        if(role == null) {
            setResponseStatus(response, HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserRegistrationService userRegistrationService = userRegistrationServiceFactory.getRegistrationService(role);
        System.out.println("3 - " + userRegistrationService);
        if(userRegistrationService == null) {
            setResponseStatus(response, HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserViewModel userViewModel = UserViewModelFactory.getViewModel(role);
        System.out.println("4 - " + userViewModel);
        if(userViewModel == null) {
            setResponseStatus(response, HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        try {
            System.out.println("5 - " + "try register");
            userRegistrationService.register(userViewModel, userParameters);
        } catch (RegistrationException e) {
            System.out.println("6 - " + "register exception SC_BAD_REQUEST");
            setResponseStatus(response, HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void setResponseStatus(HttpServletResponse response, int status) {
        response.setStatus(status);
    }

}
