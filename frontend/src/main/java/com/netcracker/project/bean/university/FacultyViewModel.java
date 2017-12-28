package com.netcracker.project.bean.university;

import java.util.Objects;

public class FacultyViewModel {

    private String id;
    private String name;
    private UniversityViewModel university;


    public FacultyViewModel() {
    }

    public FacultyViewModel(String id) {
        this.id = id;
    }


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyViewModel that = (FacultyViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, university);
    }

    @Override
    public String toString() {
        return "FacultyViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", university=" + university +
                '}';
    }

}
