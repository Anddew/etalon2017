package com.netcracker.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "requests", schema = "netcrackerappdb", catalog = "")
public class RequestEntity {
    private int id;
    private boolean checkStatus;
    private int studentRequiredCount;
    private double minAvgScore;
    private boolean requiredNoAllocation;
    private Date dateStart;
    private Date dateEnd;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "check_status", nullable = false)
    public boolean isCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Basic
    @Column(name = "student_required_count", nullable = false)
    public int getStudentRequiredCount() {
        return studentRequiredCount;
    }

    public void setStudentRequiredCount(int studentRequiredCount) {
        this.studentRequiredCount = studentRequiredCount;
    }

    @Basic
    @Column(name = "min_avg_score", nullable = true, precision = 0)
    public double getMinAvgScore() {
        return minAvgScore;
    }

    public void setMinAvgScore(double minAvgScore) {
        this.minAvgScore = minAvgScore;
    }

    @Basic
    @Column(name = "required_no_allocation", nullable = true)
    public boolean isRequiredNoAllocation() {
        return requiredNoAllocation;
    }

    public void setRequiredNoAllocation(boolean requiredNoAllocation) {
        this.requiredNoAllocation = requiredNoAllocation;
    }

    @Basic
    @Column(name = "date_start", nullable = false)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_end", nullable = false)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntity that = (RequestEntity) o;

        if (id != that.id) return false;
        if (checkStatus != that.checkStatus) return false;
        if (studentRequiredCount != that.studentRequiredCount) return false;
        if (Double.compare(that.minAvgScore, minAvgScore) != 0) return false;
        if (requiredNoAllocation != that.requiredNoAllocation) return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (checkStatus ? 1 : 0);
        result = 31 * result + studentRequiredCount;
        temp = Double.doubleToLongBits(minAvgScore);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requiredNoAllocation ? 1 : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", checkStatus=" + checkStatus +
                ", studentRequiredCount=" + studentRequiredCount +
                ", minAvgScore=" + minAvgScore +
                ", requiredNoAllocation=" + requiredNoAllocation +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                '}';
    }

}
