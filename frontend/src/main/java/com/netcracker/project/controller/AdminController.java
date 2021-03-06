package com.netcracker.project.controller;

import com.netcracker.project.bean.user.AdminViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.UserService;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admins")
public class AdminController {

    private Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));
    private final TypeDescriptor adminViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(AdminViewModel.class));


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<AdminViewModel> getAllAdmins() {
        List<UserEntity> users = userService.getAdmins();
        List<AdminViewModel> admins = (List<AdminViewModel>) conversionService.convert(users, userEntityTypeDescriptor, adminViewModelTypeDescriptor);
        logger.debug("Show all admins.");
        return admins;
    }

}
