package com.dhu.test4service.pojo;

import javax.persistence.*;

@Entity
@Table(name = "course_experiment", schema = "Test4", catalog = "")
public class CourseExperiment {
    private int id;
    private Integer collegeId;
    private String collegeName;
    private Integer courseId;
    private Integer experimentId;
    private String experimentName;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "college_id")
    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    @Basic
    @Column(name = "college_name")
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Basic
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "experiment_id")
    public Integer getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Integer experimentId) {
        this.experimentId = experimentId;
    }

    @Basic
    @Column(name = "experiment_name")
    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseExperiment that = (CourseExperiment) o;

        if (id != that.id) return false;
        if (collegeId != null ? !collegeId.equals(that.collegeId) : that.collegeId != null) return false;
        if (collegeName != null ? !collegeName.equals(that.collegeName) : that.collegeName != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (experimentId != null ? !experimentId.equals(that.experimentId) : that.experimentId != null) return false;
        if (experimentName != null ? !experimentName.equals(that.experimentName) : that.experimentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (collegeId != null ? collegeId.hashCode() : 0);
        result = 31 * result + (collegeName != null ? collegeName.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (experimentId != null ? experimentId.hashCode() : 0);
        result = 31 * result + (experimentName != null ? experimentName.hashCode() : 0);
        return result;
    }
}
