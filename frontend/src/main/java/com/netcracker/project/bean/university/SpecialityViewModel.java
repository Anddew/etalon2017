package com.netcracker.project.bean.university;

import java.util.Objects;

public class SpecialityViewModel {

    private String id;
    private String name;
    private FacultyViewModel faculty;

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

    public FacultyViewModel getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyViewModel faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialityViewModel that = (SpecialityViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, faculty);
    }

    @Override
    public String toString() {
        return "SpecialityViewModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", faculty=" + faculty +
                '}';
    }

}
