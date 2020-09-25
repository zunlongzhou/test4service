package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.CollegeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeCourseRepository extends JpaRepository<CollegeCourse,Integer> {

    List<CollegeCourse> findAll();

    List<CollegeCourse> findByCollegeId(int college_id);

    List<CollegeCourse> findByCollegeIdAndCourseId(int college_id,int course_id);
}
