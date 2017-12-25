package com.netcracker.project.controller;

import com.netcracker.project.bean.user.*;
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
@RequestMapping(value = "/heads-university")
public class HeadFromUniversityController {

    private Logger logger = Logger.getLogger(HeadFromUniversityController.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));
    private final TypeDescriptor headFromUniversityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadFromUniversityViewModel.class));

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<HeadFromUniversityViewModel> getAllHeadsFromUniversity() {
        List<UserEntity> users = userService.findAllHeadsFromUniversity();
        List<HeadFromUniversityViewModel> headsFromUniversity = (List<HeadFromUniversityViewModel>) conversionService.convert(users, userEntityTypeDescriptor, headFromUniversityViewModelTypeDescriptor);
        logger.debug("Show all heads from universities.");
        return headsFromUniversity;
    }

}
