package com.netcracker.project.controller;

import com.netcracker.project.bean.university.SpecialityViewModel;
import com.netcracker.project.entity.university.SpecialityEntity;
import com.netcracker.project.service.SpecialityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SpecialityController {

    private Logger logger = Logger.getLogger(SpecialityController.class.getSimpleName());

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private SpecialityService specialityService;

    private final TypeDescriptor specialityEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor specialityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));

    @RequestMapping(value = "/specialities/{specialityId}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityViewModel getSpecialityById(@PathVariable String specialityId) {
        int id = Integer.parseInt(specialityId);
        SpecialityEntity speciality = specialityService.getSpecialityById(id);
        logger.debug("Show speciality id=" + specialityId);
        return conversionService.convert(speciality, SpecialityViewModel.class);
    }

    @RequestMapping(value = "/speciality", method = RequestMethod.POST)
    @ResponseBody
    public void createSpeciality(@RequestBody SpecialityViewModel specialityViewModel) {
        SpecialityEntity speciality = conversionService.convert(specialityViewModel, SpecialityEntity.class);
        specialityService.addSpeciality(speciality);
    }

    @RequestMapping(value = "specialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getAllSpecialities() {
        List<SpecialityEntity> faculties = specialityService.getAllSpecialities();
        logger.debug("Show all specialities.");
        return (List<SpecialityViewModel>) conversionService.convert(faculties, specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }

}
