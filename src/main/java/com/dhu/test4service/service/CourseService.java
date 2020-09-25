package com.dhu.test4service.service;

import com.dhu.test4service.pojo.Course;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhu.test4service.pojo.User;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(int id);

    JSONArray findAllCourseDetail();

    List<User> findCourseStu(int id);

    List<Boolean> findStuCourse(int id);
}
