package com.netcracker.project.controller;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.bean.university.UniversityViewModel;
import com.netcracker.project.entity.university.FacultyEntity;
import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.entity.university.UniversityEntity;
import com.netcracker.project.service.FacultyService;
import com.netcracker.project.service.SpecialityService;
import com.netcracker.project.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UniversityController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UniversityService universityService;

    private final TypeDescriptor universityEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UniversityEntity.class));
    private final TypeDescriptor universityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UniversityViewModel.class));

    @RequestMapping(value = "/universities/{universityId}", method = RequestMethod.GET)
    @ResponseBody
    public UniversityViewModel getUniversityById(@PathVariable String universityId) {
        int id = Integer.parseInt(universityId);
        UniversityEntity university = universityService.getUniversityById(id);
        return conversionService.convert(university, UniversityViewModel.class);
    }

    @RequestMapping(value = "/university", method = RequestMethod.POST)
    @ResponseBody
    public void createUniversity(@RequestBody UniversityViewModel universityViewModel) {
        UniversityEntity university = conversionService.convert(universityViewModel, UniversityEntity.class);
        universityService.addUniversity(university);
    }

    @RequestMapping(value = "universities", method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityViewModel> getAllUniversities() {
        List<UniversityEntity> universities = universityService.getAllUniversities();
        return (List<UniversityViewModel>) conversionService.convert(universities, universityEntityTypeDescriptor, universityViewModelTypeDescriptor);
    }

}
