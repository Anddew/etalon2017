package com.netcracker.project.controller;

import com.netcracker.project.bean.user.*;
import com.netcracker.project.converter.user.UserEntityToAdminViewModelConverter;
import com.netcracker.project.converter.user.UserEntityToStudentViewModelConverter;
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
import java.util.Set;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));
    private final TypeDescriptor studentViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));
    private final TypeDescriptor headFromCompanyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadFromCompanyViewModel.class));
    private final TypeDescriptor headFromUniversityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadFromUniversityViewModel.class));
    private final TypeDescriptor adminViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(AdminViewModel.class));

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<UserEntity> users = userService.findAllStudents();
        List<StudentViewModel> students = (List<StudentViewModel>) conversionService.convert(users, userEntityTypeDescriptor, studentViewModelTypeDescriptor);
        logger.debug("Show all students.");
        return students;
    }

    @RequestMapping(value = "/heads-company", method = RequestMethod.GET)
    @ResponseBody
    public List<HeadFromCompanyViewModel> getAllHeadsFromCompany() {
        List<UserEntity> users = userService.findAllHeadsFromCompany();
        List<HeadFromCompanyViewModel> headsFromCompany = (List<HeadFromCompanyViewModel>) conversionService.convert(users, userEntityTypeDescriptor, headFromCompanyViewModelTypeDescriptor);
        logger.debug("Show all heads from companies.");
        return headsFromCompany;
    }

    @RequestMapping(value = "/heads-university", method = RequestMethod.GET)
    @ResponseBody
    public List<HeadFromUniversityViewModel> getAllHeadsFromUniversity() {
        List<UserEntity> users = userService.findAllHeadsFromUniversity();
        List<HeadFromUniversityViewModel> headsFromUniversity = (List<HeadFromUniversityViewModel>) conversionService.convert(users, userEntityTypeDescriptor, headFromUniversityViewModelTypeDescriptor);
        logger.debug("Show all heads from universities.");
        return headsFromUniversity;
    }

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    @ResponseBody
    public List<AdminViewModel> getAllAdmins() {
        List<UserEntity> users = userService.findAllAdmins();
        List<AdminViewModel> admins = (List<AdminViewModel>) conversionService.convert(users, userEntityTypeDescriptor, adminViewModelTypeDescriptor);
        logger.debug("Show all admins.");
        return admins;
    }

}
