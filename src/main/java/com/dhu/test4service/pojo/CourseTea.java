package com.dhu.test4service.pojo;

import javax.persistence.*;

@Entity
@Table(name = "course_tea", schema = "Test4", catalog = "")
public class CourseTea {
    private int id;
    private Integer courseId;
    private Integer teaId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CourseID")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "TeaID")
    public Integer getTeaId() {
        return teaId;
    }

    public void setTeaId(Integer teaId) {
        this.teaId = teaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseTea courseTea = (CourseTea) o;

        if (id != courseTea.id) return false;
        if (courseId != null ? !courseId.equals(courseTea.courseId) : courseTea.courseId != null) return false;
        if (teaId != null ? !teaId.equals(courseTea.teaId) : courseTea.teaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (teaId != null ? teaId.hashCode() : 0);
        return result;
    }
}
