package com.netcracker.project.controller;

import com.netcracker.project.bean.user.HeadFromCompanyViewModel;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/heads-company")
public class HeadFromCompanyController {

    private Logger logger = Logger.getLogger(HeadFromCompanyController.class.getSimpleName());


    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    private final TypeDescriptor headFromCompanyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadFromCompanyViewModel.class));
    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<HeadFromCompanyViewModel> getAllHeadsFromCompany() {
        List<UserEntity> users = userService.findAllHeadsFromCompany();
        List<HeadFromCompanyViewModel> headsFromCompany = (List<HeadFromCompanyViewModel>) conversionService.convert(users, userEntityTypeDescriptor, headFromCompanyViewModelTypeDescriptor);
        logger.debug("Show all heads from companies.");
        return headsFromCompany;
    }


}
