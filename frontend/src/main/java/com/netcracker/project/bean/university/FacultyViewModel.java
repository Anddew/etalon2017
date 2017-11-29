package com.netcracker.project.bean.university;

public class FacultyViewModel {

    private String id;
    private String name;
    private UniversityViewModel university;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UniversityViewModel getUniversity() {
        return university;
    }

    public void setUniversity(UniversityViewModel university) {
        this.university = university;
    }

}
