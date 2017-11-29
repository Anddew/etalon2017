package com.netcracker.project.controller;

import com.netcracker.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceImpl studentService;
//    private AdminService adminService;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestParam String role,
                        @RequestParam String email,
                        @RequestParam String password,
                        @RequestParam String firstName,
                        @RequestParam String lastName) {

        System.out.println(role + email + password + firstName + lastName);
        /*UserRole userRole = UserRole.valueOf(role.toUpperCase());
//        UserService userService = UserServiceFactory.services.get(userRole);
        UserService userService = studentService;
        if(userService != null) {
            boolean isUserExist = userService.login(email, password);
            if(isUserExist) {
                return "home";
            }

        }*/
        return "home";
    }

}
