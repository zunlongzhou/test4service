package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.CourseExperiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseExRepository extends JpaRepository<CourseExperiment,Integer> {

    List<CourseExperiment> findAll();

    CourseExperiment save(CourseExperiment courseExperiment);

    List<CourseExperiment> findByCourseId(int courseid);

    @Transactional
    @Modifying
    @Query(value = "select count(*) from course_experiment where course_id=?1",nativeQuery = true)
    int numOfCourseEx(int courseid);
}
