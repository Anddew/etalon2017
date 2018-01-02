package com.netcracker.project.dto;

import java.util.List;

public class StudentsOnPracticeDTO {

    private Integer practiceId;
    private List<Integer> studentsId;

    public StudentsOnPracticeDTO() {
    }

    public StudentsOnPracticeDTO(Integer practiceId, List<Integer> studentsId) {
        this.practiceId = practiceId;
        this.studentsId = studentsId;
    }

    public Integer getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Integer practiceId) {
        this.practiceId = practiceId;
    }

    public List<Integer> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(List<Integer> studentsId) {
        this.studentsId = studentsId;
    }


}
