package com.netcracker.project.controller;

import com.netcracker.project.bean.practice.PracticeViewModel;
import com.netcracker.project.dto.StudentsOnPracticeDTO;
import com.netcracker.project.dto.CreatePracticeDTO;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


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
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR','HEAD_FROM_COMPANY','HEAD_FROM_UNIVERSITY','STUDENT')")
    public List<PracticeViewModel> getPractices(HttpServletRequest request, HttpServletResponse response) {
        String principal = request.getUserPrincipal().getName();
        List<PracticeEntity> myPracticeEntities = practiceService.getPractices(principal);
        List<PracticeViewModel> myPractices = (List<PracticeViewModel>) conversionService.convert(myPracticeEntities, practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
        logger.debug("Show practices for user '" + principal + "' (authority - '" + SecurityContextHolder.getContext().getAuthentication().getAuthorities() + "').");
        return myPractices;
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('HEAD_FROM_COMPANY')")
    public void addPractice(@RequestBody CreatePracticeDTO practice, HttpServletRequest request, HttpServletResponse response) {
        PracticeEntity practiceEntity = new PracticeEntity();
        practiceEntity.setStatus(PracticeStatus.PROCESSING);

        String principal = request.getUserPrincipal().getName();
        UserEntity user = userService.getUserByUsername(principal);
        practiceEntity.setHeadFromCompany(user);

        FacultyEntity faculty = facultyService.getFaculty(practice.getFacultyId());
        practiceEntity.setFaculty(faculty);

        practiceEntity.setStudentRequiredCount(practice.getStudentRequiredCount());
        practiceEntity.setMinAvgScore(practice.getMinAvgScore());
        practiceEntity.setEducationForm(practice.getEducationForm());
        practiceEntity.setHireCondition(practice.getHireCondition());
        practiceEntity.setDateStart(practice.getDateStart());
        practiceEntity.setDateEnd(practice.getDateEnd());

        practiceService.createPractice(practiceEntity);
        logger.debug("Add practice for user '" + principal + "'.");
    }

    @Transactional
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('HEAD_FROM_COMPANY')")
    public void assignStudents(@RequestBody StudentsOnPracticeDTO studentsOnPractice, HttpServletRequest request, HttpServletResponse response) {
        practiceService.assignStudents(studentsOnPractice.getPracticeId(), studentsOnPractice.getStudentsId());
        logger.debug("Assign students successful.");
    }

    @Transactional
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR','HEAD_FROM_COMPANY')")
    public void releaseStudents(@RequestBody StudentsOnPracticeDTO studentsOnPractice, HttpServletRequest request, HttpServletResponse response) {
        practiceService.releaseStudents(studentsOnPractice.getPracticeId(), studentsOnPractice.getStudentsId());
        logger.debug("Release students successful.");
    }

    @Transactional
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR')")
    public void approvePractice(@RequestBody Map<String, String> data, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.valueOf(data.get("practiceId"));
        PracticeEntity practice = practiceService.getPractice(id);
        practice.setStatus(PracticeStatus.CHECKED);
        logger.info("Practice id = '" + id + "' has been successfully approved.");
    }

    @Transactional
    @RequestMapping(value = "/set-head", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR')")
    public void setHead(@RequestBody Map<String, String> data, HttpServletRequest request, HttpServletResponse response) {
        int practiceId = Integer.valueOf(data.get("practiceId"));
        int userId = Integer.valueOf(data.get("headId"));
        PracticeEntity practice = practiceService.getPractice(practiceId);
        UserEntity head = userService.getUser(userId);
        practice.setHeadFromUniversity(head);
        logger.info("Head from university id ='" + userId + "' has been successfully set for practice id = '" + practiceId + "'.");
    }

}
