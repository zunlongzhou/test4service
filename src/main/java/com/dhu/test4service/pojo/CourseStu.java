package com.dhu.test4service.pojo;

import javax.persistence.*;

@Entity
@Table(name = "course_stu", schema = "Test4", catalog = "")
public class CourseStu {
    private int id;
    private Integer courseId;
    private Integer stuId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courseID")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "StuID")
    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseStu courseStu = (CourseStu) o;

        if (id != courseStu.id) return false;
        if (courseId != null ? !courseId.equals(courseStu.courseId) : courseStu.courseId != null) return false;
        if (stuId != null ? !stuId.equals(courseStu.stuId) : courseStu.stuId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        return result;
    }
}
