package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.CourseExperiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseExRepository extends JpaRepository<CourseExperiment,Integer> {

    List<CourseExperiment> findAll();

    List<CourseExperiment> findByCollegeId(int college_id);

    List<CourseExperiment> findByCollegeIdAndCourseId(int college_id,int course_id);

    CourseExperiment save(CourseExperiment courseExperiment);
}
