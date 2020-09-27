package com.dhu.test4service.service;

import com.dhu.test4service.pojo.CourseStu;

import java.util.List;

public interface CourseStuService {
    List<CourseStu> findAll();

    List<CourseStu> findByCourseId(int courseID);

    List<CourseStu> findByStuId(int stuID);

    CourseStu save(CourseStu courseStu);

    Integer deleteCS(int courseID,int StuID);
}
