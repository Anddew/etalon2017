package com.netcracker.project.controller;

import com.netcracker.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl studentService;
//    private AdminService adminService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String role,
                        @RequestParam String email,
                        @RequestParam String password) {

//        UserRole userRole = UserRole.valueOf(role.toUpperCase());
//        UserService userService = UserServiceFactory.services.get(userRole);
        UserServiceImpl userService = studentService;
        return "register";
    }

}
