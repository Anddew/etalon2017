package com.netcracker.project.controller;

import com.netcracker.project.bean.practice.PracticeViewModel;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.practice.PracticeEntity;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.PracticeService;
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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/practices")
public class PracticeController {

    private Logger logger = Logger.getLogger(PracticeController.class.getSimpleName());

    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));
    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeEntity.class));


    @Autowired
    private ConversionService conversionService;

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getAllPractices() {
        List<PracticeEntity> practiceEntities = practiceService.findAllPractices();
        List<PracticeViewModel> practices = (List<PracticeViewModel>) conversionService.convert(practiceEntities, practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
        logger.debug("Show all practices.");
        return practices;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getAllMyPractices(HttpServletRequest request, HttpServletResponse response) {
        String principal = request.getUserPrincipal().getName();
        List<PracticeEntity> myPracticeEntities = userService.getPractices(principal);
        List<PracticeViewModel> myPractices = (List<PracticeViewModel>) conversionService.convert(myPracticeEntities, practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
        logger.debug("Show practices for user '" + principal + "'.");
        return myPractices;
    }

}
