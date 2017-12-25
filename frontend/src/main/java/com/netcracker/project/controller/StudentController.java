package com.netcracker.project.controller;

import com.netcracker.project.bean.user.StudentViewModel;
import com.netcracker.project.entity.user.UserEntity;
import com.netcracker.project.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    private final TypeDescriptor studentViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentViewModel.class));
    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserEntity.class));


    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UserService userService;


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
        UserEntity student;
        if(id == 0) {
            String principal = request.getUserPrincipal().getName();
            student = userService.findUserByUserName(principal);
        } else {
            student = userService.findStudent(id);
            StudentViewModel svm = conversionService.convert(student, StudentViewModel.class);
            request.setAttribute("student", svm);
            try {
                request.getRequestDispatcher("/jsp/student-full-info.jsp").forward(request, response);
                return null;
            } catch (Exception e) {
                // TODO: 23.12.2017  
                throw new RuntimeException("test", e);
            }
        }
        logger.debug("Show student id = '" + id + "'.");
        return conversionService.convert(student, StudentViewModel.class);
    }

}
