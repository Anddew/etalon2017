package com.netcracker.project.controller;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import com.netcracker.project.service.FacultyService;
import com.netcracker.project.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FacultyService facultyService;

    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));

    @RequestMapping(value = "/faculties/{facultyId}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyViewModel getFacultyById(@PathVariable String facultyId) {
        int id = Integer.parseInt(facultyId);
        FacultyEntity faculty = facultyService.getFacultyById(id);
        return conversionService.convert(faculty, FacultyViewModel.class);
    }

    @RequestMapping(value = "/faculty", method = RequestMethod.POST)
    @ResponseBody
    public void createFaculty(@RequestBody FacultyViewModel facultyViewModel) {
        FacultyEntity faculty = conversionService.convert(facultyViewModel, FacultyEntity.class);
        facultyService.addFaculty(faculty);
    }

    @RequestMapping(value = "faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getAllFaculties() {
        List<FacultyEntity> faculties = facultyService.getAllFaculties();
        return (List<FacultyViewModel>) conversionService.convert(faculties, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }

}
