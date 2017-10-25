package com.netcracker.devschool.dev4.entity.user;

import com.netcracker.devschool.dev4.entity.university.Speciality;

import java.util.Date;

public class Student extends User {

    protected int groupNumber;
    protected EducationForm educationForm;
    protected double avgScore;
    protected StudentPracticeStatus practiceStatus;
    protected boolean needsDistribution;
    protected Date startPracticeDate;
    protected Date finishPracticeDate;
    protected Speciality speciality;

    @Override
    public Role getRole() {
        return Role.STUDENT;
    }

}
