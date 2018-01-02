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

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "universities")
public class UniversityController {

    private Logger logger = Logger.getLogger(UniversityController.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private UniversityService universityService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SpecialityService specialityService;

    private final TypeDescriptor universityEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UniversityEntity.class));
    private final TypeDescriptor universityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UniversityViewModel.class));
    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));
    private final TypeDescriptor specialityEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor specialityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));


    @RequestMapping(value = "/{universityId}", method = RequestMethod.GET)
    @ResponseBody
    public UniversityViewModel getUniversityById(@PathVariable String universityId) {
        int id = Integer.parseInt(universityId);
        UniversityEntity university = universityService.getUniversity(id);
        logger.debug("Show university id=" + universityId);
        return conversionService.convert(university, UniversityViewModel.class);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void createUniversity(@RequestBody UniversityViewModel universityViewModel) {
        UniversityEntity university = conversionService.convert(universityViewModel, UniversityEntity.class);
        universityService.createUniversity(university);
        logger.debug("University created successfully.");
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityViewModel> getAllUniversities() {
        List<UniversityEntity> universities = universityService.getUniversities();
        logger.debug("Show all universities.");
        return (List<UniversityViewModel>) conversionService.convert(universities, universityEntityTypeDescriptor, universityViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/{universityId}/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getFacultiesByUniversityId(@PathVariable String universityId) {
        int id = Integer.parseInt(universityId);
        List<FacultyEntity> facultyEntities = facultyService.getFacultiesByUniversityId(id);
        logger.debug("Show faculties for university id=" + universityId);
        return (List<FacultyViewModel>) conversionService.convert(facultyEntities, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/faculties/{facultyId}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyViewModel getFacultyById(@PathVariable String facultyId) {
        int id = Integer.parseInt(facultyId);
        FacultyEntity faculty = facultyService.getFaculty(id);
        logger.debug("Show faculty id=" + facultyId);
        return conversionService.convert(faculty, FacultyViewModel.class);
    }

    @RequestMapping(value = "/faculty", method = RequestMethod.POST)
    @ResponseBody
    public void createFaculty(@RequestBody FacultyViewModel facultyViewModel) {
        FacultyEntity faculty = conversionService.convert(facultyViewModel, FacultyEntity.class);
        facultyService.createFaculty(faculty);
    }

    @RequestMapping(value = "faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getAllFaculties() {
        List<FacultyEntity> faculties = facultyService.getFaculties();
        logger.debug("Show all faculties");
        return (List<FacultyViewModel>) conversionService.convert(faculties, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/specialities/{specialityId}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityViewModel getSpecialityById(@PathVariable String specialityId) {
        int id = Integer.parseInt(specialityId);
        SpecialityEntity speciality = specialityService.getSpeciality(id);
        logger.debug("Show speciality id=" + specialityId);
        return conversionService.convert(speciality, SpecialityViewModel.class);
    }

    @RequestMapping(value = "/speciality", method = RequestMethod.POST)
    @ResponseBody
    public void createSpeciality(@RequestBody SpecialityViewModel specialityViewModel) {
        SpecialityEntity speciality = conversionService.convert(specialityViewModel, SpecialityEntity.class);
        specialityService.createSpeciality(speciality);
    }

    @RequestMapping(value = "specialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getAllSpecialities() {
        List<SpecialityEntity> faculties = specialityService.getSpecialities();
        logger.debug("Show all specialities.");
        return (List<SpecialityViewModel>) conversionService.convert(faculties, specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }

}
