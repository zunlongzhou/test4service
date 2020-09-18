package com.dhu.test4service.dao;


import com.dhu.test4service.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findAll();

    Course findById(int id);
}
