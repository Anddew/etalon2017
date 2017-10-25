package com.netcracker.devschool.dev4.entity.user.headfromuniversity;

import com.netcracker.devschool.dev4.entity.university.Faculty;
import com.netcracker.devschool.dev4.entity.user.Role;
import com.netcracker.devschool.dev4.entity.user.User;

public class HeadFromUniversity extends User {

    protected String position;
    protected Faculty faculty;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public Role getRole() {
        return Role.HEAD_UNIVERSITY;
    }

}
