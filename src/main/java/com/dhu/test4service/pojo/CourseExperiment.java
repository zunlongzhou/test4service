package com.dhu.test4service.pojo;

import javax.persistence.*;

@Entity
@Table(name = "course_experiment", schema = "Test4", catalog = "")
public class CourseExperiment {
    private int id;
    private Integer courseId;
    private Integer experimentId;
    private String experimentName;
    private String experimentIntro;
    private String video;
    private String action;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Basic
    @Column(name = "experiment_intro")
    public String getExperimentIntro() {
        return experimentIntro;
    }

    public void setExperimentIntro(String experimentIntro) {
        this.experimentIntro = experimentIntro;
    }

    @Basic
    @Column(name = "video")
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Basic
    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseExperiment that = (CourseExperiment) o;

        if (id != that.id) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (experimentId != null ? !experimentId.equals(that.experimentId) : that.experimentId != null) return false;
        if (experimentName != null ? !experimentName.equals(that.experimentName) : that.experimentName != null)
            return false;
        if (experimentIntro != null ? !experimentIntro.equals(that.experimentIntro) : that.experimentIntro != null)
            return false;
        if (video != null ? !video.equals(that.video) : that.video != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (experimentId != null ? experimentId.hashCode() : 0);
        result = 31 * result + (experimentName != null ? experimentName.hashCode() : 0);
        result = 31 * result + (experimentIntro != null ? experimentIntro.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }
}
