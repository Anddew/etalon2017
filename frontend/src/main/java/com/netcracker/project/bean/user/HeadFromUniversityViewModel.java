package com.netcracker.project.bean.user;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.entity.user.UserRole;

public class HeadFromUniversityViewModel extends UserViewModel {

    private FacultyViewModel faculty;

    public FacultyViewModel getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyViewModel faculty) {
        this.faculty = faculty;
    }

    @Override
    public UserRole getRole() {
        return UserRole.HEAD_FROM_UNIVERSITY;
    }

    @Override
    public String toString() {
        return "HeadFromUniversityViewModel{" +
                "faculty=" + faculty +
                "} " + super.toString();
    }
}
