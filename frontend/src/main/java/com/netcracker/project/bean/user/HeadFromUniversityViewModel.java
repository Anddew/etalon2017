package com.netcracker.project.bean.user;

import com.netcracker.project.bean.university.FacultyViewModel;
import com.netcracker.project.entity.user.UserRole;

import java.util.Objects;

public class HeadFromUniversityViewModel extends UserViewModel {

    private static final long serialVersionUID = 3963532595057266433L;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadFromUniversityViewModel that = (HeadFromUniversityViewModel) o;
        return Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }

    @Override
    public String toString() {
        return "HeadFromUniversityViewModel{" +
                "faculty=" + faculty +
                "} " + super.toString();
    }

}
