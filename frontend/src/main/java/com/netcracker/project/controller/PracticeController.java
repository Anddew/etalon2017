package com.netcracker.project.controller;

import com.netcracker.project.bean.practice.PracticeViewModel;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.practice.PracticeStatus;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.FacultyService;
import com.netcracker.project.service.PracticeService;
import com.netcracker.project.service.UserService;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping(value = "/practices")
public class PracticeController {

    private Logger logger = Logger.getLogger(PracticeController.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private FacultyService facultyService;

    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));
    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeEntity.class));


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getPractices(HttpServletRequest request, HttpServletResponse response) {
        String principal = request.getUserPrincipal().getName();
        List<PracticeEntity> myPracticeEntities = userService.getPractices(principal);
        List<PracticeViewModel> myPractices = (List<PracticeViewModel>) conversionService.convert(myPracticeEntities, practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
        logger.debug("Show practices for user '" + principal + "' (authority - '" + SecurityContextHolder.getContext().getAuthentication().getAuthorities() + "').");
        return myPractices;
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPractice(@RequestBody PracticeViewModel practice, HttpServletRequest request, HttpServletResponse response) {
        PracticeEntity practiceEntity = conversionService.convert(practice, PracticeEntity.class);

        String principal = request.getUserPrincipal().getName();
        UserEntity user = userService.findUserByUserName(principal);
        practiceEntity.setHeadFromCompany(user);

        FacultyEntity faculty = facultyService.getFacultyById(Integer.parseInt(practice.getFaculty().getId()));
        practiceEntity.setFaculty(faculty);

        practiceEntity.setStatus(PracticeStatus.PROCESSING);
        practiceService.createPractice(practiceEntity);
        logger.debug("Add practice for user '" + principal + "'.");
    }

}
