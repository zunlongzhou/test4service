package com.dhu.test4service.service;


import com.dhu.test4service.pojo.CourseTea;

import java.util.List;

public interface CourseTeaService {
    List<CourseTea> findAll();

    List<CourseTea> findByCourseId(int courID);

    List<CourseTea> findByTeaId(int teaID);

}
