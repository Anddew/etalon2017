package com.netcracker.devschool.dev4.entity.user.student;

import com.netcracker.devschool.dev4.entity.university.Speciality;
import com.netcracker.devschool.dev4.entity.user.Role;
import com.netcracker.devschool.dev4.entity.user.User;

import java.util.Date;

public class Student extends User {

    protected int groupNumber;
    protected String educationForm;
    protected double avgScore;
    protected boolean onPracticeStatus;
    protected boolean hasAllocation;
    protected Date startPracticeDate;
    protected Date finishPracticeDate;
    protected Speciality speciality;

    @Override
    public Role getRole() {
        return Role.STUDENT;
    }

}
