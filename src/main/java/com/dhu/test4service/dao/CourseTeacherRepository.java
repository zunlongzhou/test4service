package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.CourseTea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseTeacherRepository extends JpaRepository<CourseTea,Integer> {

    List<CourseTea> findAll();

    List<CourseTea> findByCourseId(int courID);

    List<CourseTea> findByTeaId(int teaID);

    CourseTea save(CourseTea courseTea);
}
