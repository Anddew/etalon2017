package com.netcracker.project.bean.user;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.entity.user.Role;

public class HeadFromUniversityViewModel extends UserViewModel {

    private FacultyViewModel faculty;

    public FacultyViewModel getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyViewModel faculty) {
        this.faculty = faculty;
    }

    @Override
    public Role getRole() {
        return Role.HEAD_FROM_UNIVERSITY;
    }

}
