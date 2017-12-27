package com.netcracker.project.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.entity.user.student.EducationForm;
import com.netcracker.project.entity.user.student.HireCondition;
import com.netcracker.project.entity.user.student.StudentEntity;
import com.netcracker.project.service.UserService;
import com.netcracker.project.validation.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/students")
public class StudentController {

    private Logger logger = Logger.getLogger(StudentController.class.getSimpleName());

    private static final String STUDENT_PAGE_PATH = "/jsp/student-full.jsp";
    private static final String STUDENT_PARAMETER_NAME = "student";
    private static final String AVG_SCORE_PARAMETER_NAME = "avgScore";
    private static final String EDUCATION_FORM_PARAMETER_NAME = "educationForm";
    private static final String HIRE_CONDITION_PARAMETER_NAME = "hireCondition";

    private final TypeDescriptor studentViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));
    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));


    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<StudentViewModel> getAllStudents() {
        List<UserEntity> users = userService.findAllStudents();
        List<StudentViewModel> students = (List<StudentViewModel>) conversionService.convert(users, userEntityTypeDescriptor, studentViewModelTypeDescriptor);
        logger.debug("Show all students.");
        return students;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentViewModel getFullStudentInfo(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        UserEntity user;
        StudentViewModel student;
        if(id == 0) {
            String principal = request.getUserPrincipal().getName();
            user = userService.findUserByUserName(principal);
            student = conversionService.convert(user, StudentViewModel.class);
            logger.debug("Show student id = '" + id + "'.");
        } else {
            user = userService.findStudent(id);
            student = conversionService.convert(user, StudentViewModel.class);
            request.setAttribute(STUDENT_PARAMETER_NAME, student);
            try {
                request.getRequestDispatcher(STUDENT_PAGE_PATH).forward(request, response);
                logger.debug("Show student id = '" + id + "'.");
            } catch (ServletException | IOException e) {
                logger.error("Cannot forward to '" + STUDENT_PAGE_PATH + "'.");
            }
        }
        return student;
    }

    @RequestMapping(value = "/{id}/setInfo", method = RequestMethod.POST)
    @ResponseBody
    public StudentViewModel setStudentInfo(@PathVariable int id, @RequestBody Map<String, String> data, HttpServletRequest request, HttpServletResponse response) {
        String avgScoreData = data.get(AVG_SCORE_PARAMETER_NAME);
        String educationFormData = data.get(EDUCATION_FORM_PARAMETER_NAME);
        String hireConditionData = data.get(HIRE_CONDITION_PARAMETER_NAME);
        if(!userValidator.validateAvgScoreField(avgScoreData)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        double avgScore = Double.valueOf(avgScoreData);

        if(!userValidator.validateEducationForm(educationFormData)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        EducationForm educationForm = EducationForm.valueOf(educationFormData);

        if(!userValidator.validateHiring(hireConditionData)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }
        HireCondition hireCondition = HireCondition.valueOf(hireConditionData);

        userService.setStudentDetails(id, avgScore, educationForm, hireCondition);

        StudentViewModel student = new StudentViewModel();
        student.setAvgScore(String.valueOf(avgScore));
        student.setEducationForm(educationForm.getDescription());
        student.setHireCondition(hireCondition.getDescription());
        return student;
    }

    @RequestMapping(value = "/practice/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getStudentsFromPractice(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        List<UserEntity> users = userService.findStudentsFromPractice(id);
        List<StudentViewModel> students = (List<StudentViewModel>) conversionService.convert(users, userEntityTypeDescriptor, studentViewModelTypeDescriptor);
        logger.debug("Show students from practice id = '" + id + "' for user '" + request.getUserPrincipal().getName() + "' (authority - '" + SecurityContextHolder.getContext().getAuthentication().getAuthorities() + "').");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("practice-students");
        modelAndView.addObject("students", students);
//        return students;
        return modelAndView;
    }

}
