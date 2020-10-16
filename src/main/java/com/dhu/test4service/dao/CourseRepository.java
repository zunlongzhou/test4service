package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findAll();

    List<Course> findByCollegeId(int collegeid);

    Course findById(int id);

    Course save(Course course);
}
